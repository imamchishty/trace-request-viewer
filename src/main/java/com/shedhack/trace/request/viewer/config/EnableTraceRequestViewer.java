package com.shedhack.trace.request.viewer.config;

import org.springframework.context.annotation.Import;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/**
 * <pre>
 * </pre>
 *
 * @author imamchishty
 */
@Target({java.lang.annotation.ElementType.TYPE})
@Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
@Documented
@Import(TraceRequestViewerConfiguration.class)
public @interface EnableTraceRequestViewer {
}
