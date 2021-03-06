/*
 * Copyright 2014, Red Hat, Inc. and individual contributors
 * as indicated by the @author tags. See the copyright.txt file in the
 * distribution for a full listing of individual contributors.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */

package org.zanata.servlet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import se.jiderhamn.classloader.leak.prevention.ClassLoaderLeakPreventor;

/**
 * @author Sean Flanigan <a href="mailto:sflaniga@redhat.com">sflaniga@redhat.com</a>
 *
 */
@SuppressFBWarnings({"SLF4J_SIGN_ONLY_FORMAT"})
public class LeakListener extends ClassLoaderLeakPreventor {

    private static final Logger log = LoggerFactory
            .getLogger(LeakListener.class);

    protected void debug(String s) {
        log.debug("{}", s);
    }

    protected void info(String s) {
        log.info("{}", s);
    }

    protected void warn(String s) {
        log.warn("{}", s);
    }

    protected void warn(Throwable t) {
        log.warn("warning", t);
    }

    protected void error(String s) {
        log.error("{}", s);
    }

    protected void error(Throwable t) {
        log.error("error", t);
    }

}
