/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2017 Newhouse (nhitbh at gmail dot com)
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.fooock.shodan.model.banner;

/**
 * If the service uses SSL, such as HTTPS, then the banner will also contain this object info
 */
public class SslInfo {

    private String[] chain;
    private String[] versions;

    private Cipher cipher;
    private DiffieHellmanParams diffieHellmanParams;

    SslInfo() {

    }

    /**
     * @return An array of certificates, where each string is a PEM-encoded SSL certificate.
     * This includes the user SSL certificate up to its root certificate.
     */
    public String[] getChain() {
        return chain;
    }

    /**
     * @return A list of SSL versions that are supported by the server. If a version isn't supported
     * the value is prefixed with a "-". Example: ["TLSv1", "-SSLv2"] means that the server supports TLSv1
     * but doesn't support SSLv2.
     */
    public String[] getVersions() {
        return versions;
    }

    /**
     * @return Preferred cipher for the SSL connection
     */
    public Cipher getCipher() {
        return cipher;
    }

    /**
     * @return The Diffie-Hellman parameters if available
     */
    public DiffieHellmanParams getDiffieHellmanParams() {
        return diffieHellmanParams;
    }

    void setChain(String[] chain) {
        this.chain = chain;
    }

    void setVersions(String[] versions) {
        this.versions = versions;
    }

    void setCipher(Cipher cipher) {
        this.cipher = cipher;
    }

    void setDiffieHellmanParams(DiffieHellmanParams diffieHellmanParams) {
        this.diffieHellmanParams = diffieHellmanParams;
    }
}
