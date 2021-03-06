/*
 *  (c) Copyright 2000, 2001, 2002, 2003, 2004, 2005, 2006, 2007, 2008, 2009 Hewlett-Packard Development Company, LP
 *  All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 * 1. Redistributions of source code must retain the above copyright
 *    notice, this list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright
 *    notice, this list of conditions and the following disclaimer in the
 *    documentation and/or other materials provided with the distribution.
 * 3. The name of the author may not be used to endorse or promote products
 *    derived from this software without specific prior written permission.
 
 * THIS SOFTWARE IS PROVIDED BY THE AUTHOR ``AS IS'' AND ANY EXPRESS OR
 * IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES
 * OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED.
 * IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR ANY DIRECT, INDIRECT,
 * INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT
 * NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 * DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
 * THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF
 * THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 *
 *
 * LazyZipEntryInputStream.java
 *
 * Created on November 28, 2001, 11:38 AM
 */

package com.hp.hpl.jena.shared.wg;


import java.io.*;
import java.util.zip.*;

/**
 *In test cases we cannot open all the input files
 * while creating the test suite, but must defer the
 * opening until the test is actually run.
 * @author  jjc
 */
class LazyZipEntryInputStream extends LazyInputStream {

    private ZipEntry entry;
    private ZipFile  zip;
    /** Creates new LazyZipEntryInputStream */
    LazyZipEntryInputStream(ZipFile zip,String name) {
      //  System.err.println(name);
        entry = new ZipEntry(name);
        this.zip = zip;
    }
    
    
    @Override
    InputStream open() throws IOException {
    	InputStream rslt = zip.getInputStream(entry);
    	if ( rslt == null )
    	  throw new IllegalArgumentException(entry.getName()+ " cannot be opened.");
    	return rslt;
    }
    
    

}
