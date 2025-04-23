package org.example;

import org.biojava.nbio.core.sequence.DNASequence;
import org.biojava.nbio.core.sequence.io.FastaReaderHelper;
import java.io.*;
import java.util.*;

public class Main {
    private static final String FILE_PATH = "data/LUNG_ONCOGENE_DATA.txt"; // Path to your reference FASTA file

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Get the gene name and sequence from user input
        System.out.print("Enter the gene name (e.g., EGFR, ALK): ");
        String userGene = sc.nextLine().trim();  // Get the gene name
        System.out.print("Enter the gene sequence: ");
        String userSequence = sc.nextLine().replaceAll("\\s+", "");  // Remove spaces/newlines

        // Load the reference sequences using BioJava's FASTA reader
        File inputFile = new File(FILE_PATH);
        Map<String, DNASequence> referenceSequences = new HashMap<>();

        try {
            referenceSequences = FastaReaderHelper.readFastaDNASequence(inputFile);
        } catch (IOException e) {
            System.err.println("Error reading the FASTA file: " + e.getMessage());
            return;
        }

        // Check for matching gene and sequence
        boolean geneFound = false;
        boolean mutationFound = false;

        for (Map.Entry<String, DNASequence> entry : referenceSequences.entrySet()) {
            String header = entry.getKey();
            DNASequence refSequence = entry.getValue();

            // Check if the header contains the user-provided gene name
            if (header.contains(userGene)) {
                System.out.println("Gene " + userGene + " found in the reference file.");
                geneFound = true;

                // Compare the user input sequence with the reference sequence
                if (refSequence.getSequenceAsString().equals(userSequence)) {
                    System.out.println("The sequence matches the reference sequence: " + header);
                } else {
                    System.out.println("Mutation detected in the sequence!");
                    System.out.println("Reference: " + refSequence.getSequenceAsString());
                    System.out.println("User Input: " + userSequence);
                    System.out.println("Header: " + header);

                    // Print exact positions where the mutation occurs
                    mutationFound = true;
                    int minLength = Math.min(refSequence.getLength(), userSequence.length());
                    for (int i = 0; i < minLength; i++) {
                        // Compare nucleotide bases directly using strings
                        if (refSequence.getSequenceAsString().charAt(i) != userSequence.charAt(i)) {
                            System.out.println("Mutation at position: " + (i + 1));
                        }
                    }

                    // Check if the sequences differ in length and report it
                    if (refSequence.getLength() != userSequence.length()) {
                        System.out.println("The sequences have different lengths.");
                    }
                }
            }
        }

        // If the gene was not found
        if (!geneFound) {
            System.out.println("Gene " + userGene + " not found in the reference file.");
        }

        // If no mutation was found
        if (!mutationFound && geneFound) {
            System.out.println("No mutations detected.");
        }
    }
}