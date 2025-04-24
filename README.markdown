# Lung Oncogene Mutation Analysis

This project develops a mutation prediction tool using BioJava to analyze genetic mutations in 11 lung cancer-related oncogenes: ALK, MET, STK11, ROS1, PIK3CA, RET, EGFR, BRAF, KRAS, TNF, and TP53. The tool compares user-provided gene sequences with reference sequences in FASTA format to detect mutations, including point mutations, insertions, and deletions.

## Project Overview
- **Objective**: Automate mutation detection in lung cancer oncogenes for research and clinical diagnostics.
- **Tool**: BioJava for sequence handling, alignment, and mutation detection.
- **Input**: User-provided gene name and sequence, compared against a reference FASTA file.
- **Output**: Mutation details, including type and position.

## Prerequisites
- Java Development Kit (JDK) 8 or higher
- Maven for dependency management
- BioJava library
- Reference FASTA file (`LUNG_ONCOGENE_DATA.txt`)

## Installation
1. Clone the repository:
   ```bash
   git clone https://github.com/sri-megha/Lung-Oncogene-Mutation-Analysis.git
   cd Lung-Oncogene-Mutation-Analysis
   ```
2. Install dependencies using Maven:
   ```bash
   mvn install
   ```
3. Place the reference FASTA file (`LUNG_ONCOGENE_DATA.txt`) in the `data/` directory.

## Usage
1. Compile and run the Java program:
   ```bash
   mvn compile
   mvn exec:java -Dexec.mainClass="org.example.Main"
   ```
2. Enter the gene name (e.g., EGFR) and sequence when prompted.
3. View the output, which indicates whether mutations were detected and their positions.

## Project Structure
```
Lung-Oncogene-Mutation-Analysis/
├── src/
│   └── org/example/Main.java
├── data/
│   └── LUNG_ONCOGENE_DATA.txt
├── README.md
├── .gitignore
└── pom.xml
```

## Dependencies
- BioJava Core: For sequence handling and mutation detection
- Maven: For project build and dependency management

## Notes
- Ensure the reference FASTA file is correctly formatted and contains sequences for the 11 oncogenes.
- The tool assumes the input sequence is in a valid DNA format (A, T, C, G).

## License
This project is licensed under the MIT License.

- References: [Nature](https://www.nature.com/articles/s41598-023-34016-y), [MDPI](https://www.mdpi.com/1424-8247/16/7/932), [BioJava](https://biojava.org/)
