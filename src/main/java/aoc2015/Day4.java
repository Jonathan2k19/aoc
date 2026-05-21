package aoc2015;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HexFormat;

public class Day4 {
    public static void main(final String[] args) {
        final String input = "ckczppom";

        System.out.println(solve(input, 5));
        System.out.println(solve(input, 6));
    }

    static int solve(final String input, final int nZeroes) {
        int i = 0;
        final String prefix = "0".repeat(nZeroes);

        try {
            final MessageDigest md5 = MessageDigest.getInstance("MD5");
            while (i >= 0) {
                md5.update((input + i).getBytes());
                final String hexHash = HexFormat.of().formatHex(md5.digest());
                if (hexHash.startsWith(prefix))
                    break;
                i++;
            }
        } catch (final NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        return i;
    }
}
