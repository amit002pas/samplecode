package cosine;

import java.util.Map;

//import info.debatty.java.stringsimilarity.interfaces.NormalizedStringSimilarity;
//import info.debatty.java.stringsimilarity.interfaces.NormalizedStringDistance;
//import java.util.Map;

//import net.jcip.annotations.Immutable;

/**
 * The similarity between the two strings is the cosine of the angle between
 * these two vectors representation. It is computed as V1 . V2 / (|V1| * |V2|)
 * The cosine distance is computed as 1 - cosine similarity.
 *
 * @author Thibault Debatty
 */
//@Immutable
public class Cosine extends ShingleBased{

    /**
     * Implements Cosine Similarity between strings. The strings are first
     * transformed in vectors of occurrences of k-shingles (sequences of k
     * characters). In this n-dimensional space, the similarity between the two
     * strings is the cosine of their respective vectors.
     *
     * @param k
     */
    public Cosine(final int k) {
        super(k);
    }

    /**
     * Implements Cosine Similarity between strings. The strings are first
     * transformed in vectors of occurrences of k-shingles (sequences of k
     * characters). In this n-dimensional space, the similarity between the two
     * strings is the cosine of their respective vectors. Default k is 3.
     */
    public Cosine() {
        super();
    }

    /**
     * Compute the cosine similarity between strings.
     *
     * @param s1 The first string to compare.
     * @param s2 The second string to compare.
     * @return The cosine similarity in the range [0, 1]
     * @throws NullPointerException if s1 or s2 is null.
     */
    public final double similarity(final String s1, final String s2) {
    //	System.out.println("Inside similarity");
        if (s1 == null) {
            throw new NullPointerException("s1 must not be null");
        }

        if (s2 == null) {
            throw new NullPointerException("s2 must not be null");
        }

        if (s1.equals(s2)) {
            return 1;
        }

        if (s1.length() < getK() || s2.length() < getK()) {
            return 0;
        }
        
        Map<String, Integer> profile1 = getProfile(s1);
        //System.out.println("String1: "+profile1);
        Map<String, Integer> profile2 = getProfile(s2);
        //System.out.println("String2: "+profile2);
        
        return dotProduct(profile1, profile2)
                / (norm(profile1) * norm(profile2));
    }

    /**
     * Compute the norm L2 : sqrt(Sum_i( v_i²)).
     *
     * @param profile
     * @return L2 norm
     */
    private static double norm(final Map<String, Integer> profile) {
        double agg = 0;

        for (Map.Entry<String, Integer> entry : profile.entrySet()) {
            agg += 1.0 * entry.getValue() * entry.getValue();
        }

        return Math.sqrt(agg);
    }

    private static double dotProduct(
            final Map<String, Integer> profile1,
            final Map<String, Integer> profile2) {

        // Loop over the smallest map
        Map<String, Integer> small_profile = profile2;
        Map<String, Integer> large_profile = profile1;
        if (profile1.size() < profile2.size()) {
            small_profile = profile1;
            large_profile = profile2;
        }

        double agg = 0;
        for (Map.Entry<String, Integer> entry : small_profile.entrySet()) {
            Integer i = large_profile.get(entry.getKey());
            if (i == null) {
                continue;
            }
            agg += 1.0 * entry.getValue() * i;
        }

        return agg;
    }

    /**
     * Return 1.0 - similarity.
     *
     * @param s1 The first string to compare.
     * @param s2 The second string to compare.
     * @return 1.0 - the cosine similarity in the range [0, 1]
     * @throws NullPointerException if s1 or s2 is null.
     */
    public final double distance(final String s1, final String s2) {
        return 1.0 - similarity(s1, s2);
    }

    /**
     * {@inheritDoc}
     * @param profile1
     * @param profile2
     * @return
     */
    public final double similarity(
            final Map<String, Integer> profile1,
            final Map<String, Integer> profile2) {

        return dotProduct(profile1, profile2)
                / (norm(profile1) * norm(profile2));
    }
    
    public static void main(String args[]){
    	Cosine obj=new Cosine();
    	int start=(int) System.currentTimeMillis();
    	//for(int i=0;i<100000;i++)
    	System.out.println("Result :"+obj.similarity("com.yodlee.dap.gatherer.fgyh eption: new account tag found : 2649 Mtg	at FifthThirdBase.getContainerType(FifthThirdBase.java:","com.yodlee.dap.gatherer.gather.exceptions.GeneralException: new account tag found : water st	at FifthThirdBase.getContainerType(FifthThirdBase.java:"));
    	int end=(int) System.currentTimeMillis();
    	System.out.println("Time taken: "+(end-start));
    }

}