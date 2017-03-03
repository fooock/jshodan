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
 * The Diffie-Hellman parameters if available: "prime", "public_key", "bits", "generator" and an optional
 * "fingerprint" if we know which program generated these parameters.
 */
public class DiffieHellmanParams {

    private int bits;

    private String prime;
    private String publicKey;
    private String generator;
    private String fingerprint;

    DiffieHellmanParams() {

    }

    public int getBits() {
        return bits;
    }

    public String getPrime() {
        return prime;
    }

    public String getPublicKey() {
        return publicKey;
    }

    public String getGenerator() {
        return generator;
    }

    public String getFingerprint() {
        return fingerprint;
    }

    void setBits(int bits) {
        this.bits = bits;
    }

    void setPrime(String prime) {
        this.prime = prime;
    }

    void setPublicKey(String publicKey) {
        this.publicKey = publicKey;
    }

    void setGenerator(String generator) {
        this.generator = generator;
    }

    void setFingerprint(String fingerprint) {
        this.fingerprint = fingerprint;
    }

    @Override
    public String toString() {
        return "DiffieHellmanParams{" +
                "bits=" + bits +
                ", prime='" + prime + '\'' +
                ", publicKey='" + publicKey + '\'' +
                ", generator='" + generator + '\'' +
                ", fingerprint='" + fingerprint + '\'' +
                '}';
    }
}
