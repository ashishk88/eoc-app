package edu.asu.wpcarey.eoc.utils;

import java.security.Key;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.lang3.StringUtils;

import sun.misc.BASE64Decoder;

// Program taken from http://doraprojects.net/blog/?p=1276
public class AESCrypt {

	private static final String ALGORITHM = "AES";
	private static final String KEY = "1Hbfh667adfDEJ78";

	public static String decrypt(final String value) {
		try {
			final Key key = generateKey();
			final Cipher cipher = Cipher.getInstance(AESCrypt.ALGORITHM);
			cipher.init(Cipher.DECRYPT_MODE, key);
			final byte[] decryptedValue64 = new BASE64Decoder().decodeBuffer(value);
			final byte[] decryptedByteValue = cipher.doFinal(decryptedValue64);
			final String decryptedValue = new String(decryptedByteValue, "utf-8");
			return decryptedValue;
		} catch (final Exception exception) {
			return StringUtils.EMPTY;
		}
	}

	private static Key generateKey() throws Exception {
		final Key key = new SecretKeySpec(AESCrypt.KEY.getBytes(), AESCrypt.ALGORITHM);
		return key;
	}
}