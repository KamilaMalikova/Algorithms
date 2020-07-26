package com.company;

import java.util.HashMap;
import java.util.function.DoubleToIntFunction;

public class StringSearch {

    public static void RabinKarpSearch(String txt, String pat){
        int d = 256;
        int q = 101;
        int M = pat.length();
        int N = txt.length();
        int i, j;
        int p = 0; // hash value for pattern
        int t = 0; // hash value for txt
        int h = 1;

        // The value of h would be "pow(d, M-1)%q"
        for (i = 0; i < M-1; i++)
            h = (h*d)%q;

        // Calculate the hash value of pattern and first
        // window of text
        for (i = 0; i < M; i++)
        {
            p = (d*p + pat.charAt(i))%q;
            t = (d*t + txt.charAt(i))%q;
        }

        // Slide the pattern over text one by one
        for (i = 0; i <= N - M; i++)
        {

            // Check the hash values of current window of text
            // and pattern. If the hash values match then only
            // check for characters on by one
            if ( p == t )
            {
                /* Check for characters one by one */
                for (j = 0; j < M; j++)
                {
                    if (txt.charAt(i+j) != pat.charAt(j))
                        break;
                }

                // if p == t and pat[0...M-1] = txt[i, i+1, ...i+M-1]
                if (j == M)
                    System.out.println("Pattern found at index " + i);
            }

            // Calculate hash value for next window of text: Remove
            // leading digit, add trailing digit
            if ( i < N-M )
            {
                t = (d*(t - txt.charAt(i)*h) + txt.charAt(i+M))%q;

                // We might get negative value of t, converting it
                // to positive
                if (t < 0)
                    t = (t + q);
            }
        }
    }
    public static void BoyerMoore(String text, String pattern){
        int patternLen = pattern.length();
        int textLen = text.length();
        HashMap<Character, Integer> offsetTable = new HashMap<>();
        for (int i = 0; i < patternLen - 1; i++) {
            offsetTable.put(pattern.charAt(i), patternLen - i - 1);
        }
        int index;
        offsetTable.put(pattern.charAt(patternLen-1), patternLen);
        for (int i = patternLen-1; i < textLen; i++) {
            if (text.charAt(i) == pattern.charAt(patternLen-1)){
                int patternIndex = patternLen-1;
                int textIndex = i;
                while (text.charAt(textIndex) == pattern.charAt(patternIndex)){
                    if ((textIndex == 0 || patternIndex == 0)) break;
                    textIndex--;
                    patternIndex--;
                }
                if (patternIndex == 0){
                    index = textIndex;
                    System.out.println("Found at index "+index);
                }
            }
            else if (offsetTable.containsKey(text.charAt(i))){
                i+=offsetTable.get(text.charAt(i))-1;
            }
        }
    }
}
