/**
 * Copyright 2013 Ognyan Bankov
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.github.volley_examples.toolbox;

import org.apache.http.conn.ssl.SSLSocketFactory;

import java.io.IOException;
import java.io.InputStream;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;

class SslSocketFactory extends SSLSocketFactory {
    public SslSocketFactory(InputStream keyStore, String keyStorePassword)
            throws GeneralSecurityException {
        super(createKeyStore(keyStore, keyStorePassword));
    }

    private static KeyStore createKeyStore(InputStream keyStore, String password)
            throws KeyStoreException, NoSuchAlgorithmException, CertificateException {
        KeyStore key = KeyStore.getInstance(KeyStore.getDefaultType());
        try {
            key.load(keyStore, password.toCharArray());
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            try {
                key.load(null, null);
            } catch (IOException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        }
        return key;
    }
}
