import java.util.Scanner;

public class kalkulator {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int pilihan = -1;

        while (pilihan != 0) {
            System.out.println("\n=== KALKULATOR MATEMATIKA & MATRIKS ===");
            System.out.println("1. Hitung Faktorial (n!)");
            System.out.println("2. Hitung Perpangkatan (a^b)");
            System.out.println("3. Perkalian Matriks 2x2");
            System.out.println("0. Keluar");
            System.out.print("Pilih menu: ");
            pilihan = input.nextInt();

            switch (pilihan) {
                case 1:
                    System.out.print("Masukkan bilangan bulat  ");
                    int n = input.nextInt();
                    if (n < 0) {
                        System.out.println("Faktorial tidak bisa untuk bilangan negatif.");
                    } else {
                        System.out.println("Hasil " + n + "! = " + hitungFaktorial(n));
                    }
                    break;

                case 2:
                    System.out.print("Masukkan bilangan pokok (a): ");
                    int a = input.nextInt();
                    System.out.print("Masukkan pangkat (b): ");
                    int b = input.nextInt();
                    System.out.println("Hasil " + a + "^" + b + " = " + hitungPangkat(a, b));
                    break;

                case 3:
                    perkalianMatriks(input);
                    break;

                case 0:
                    System.out.println("Program selesai. Terima kasih!");
                    break;

                default:
                    System.out.println("Pilihan tidak valid, silakan coba lagi.");
            }
        }
        input.close();
    }

    
    public static long hitungFaktorial(int n) {
        if (n <= 1) { // Base case
            return 1;
        }
        return n * hitungFaktorial(n - 1); 
    }

    
    public static long hitungPangkat(int a, int b) {
        long hasil = 1;
        for (int i = 0; i < b; i++) {
            hasil *= a;
        }
        return hasil;
    }

    
    public static void perkalianMatriks(Scanner input) {
        int[][] matriksA = new int[2][2];
        int[][] matriksB = new int[2][2];
        int[][] hasil = new int[2][2];

        System.out.println("Masukkan elemen Matriks A (2x2):");
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.print("A[" + i + "][" + j + "]: ");
                matriksA[i][j] = input.nextInt();
            }
        }

        System.out.println("Masukkan elemen Matriks B (2x2):");
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.print("B[" + i + "][" + j + "]: ");
                matriksB[i][j] = input.nextInt();
            }
        }

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                hasil[i][j] = 0;
                for (int k = 0; k < 2; k++) {
                    hasil[i][j] += matriksA[i][k] * matriksB[k][j];
                }
            }
        }

        System.out.println("Hasil Perkalian Matriks A x B:");
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.print(hasil[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
