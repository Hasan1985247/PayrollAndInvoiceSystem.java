import java.util.Scanner;



public class PayrollAndInvoiceSystem {



    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        double accountBalance = 1500; // Initial account balance

        boolean exit = false;



        while (!exit) {

            // Display menu

            System.out.println("\nVälkommen! Välj ett alternativ:");

            System.out.println("1. Betala ut löner till anställda");

            System.out.println("2. Skapa ny faktura");

            System.out.println("3. Betala en eller flera fakturor");

            System.out.println("4. Avsluta");

            System.out.print("Ditt val: ");



            int choice = scanner.nextInt();



            switch (choice) {

                case 1:

                    // Pay salaries to employees

                    System.out.print("Ange antal anställda som ska få lön: ");

                    int numEmployees = scanner.nextInt();

                    double[] salaries = new double[numEmployees];



                    for (int i = 0; i < numEmployees; i++) {

                        System.out.print("Ange lön för anställd " + (i + 1) + ": ");

                        salaries[i] = scanner.nextDouble();

                    }



                    System.out.println("\nLöner efter 30% skatt:");

                    for (int i = 0; i < numEmployees; i++) {

                        double netSalary = salaries[i] * 0.7; // Calculate net salary after 30% tax

                        System.out.printf("Anställd %d: %.2f%n", (i + 1), netSalary);

                    }

                    break;



                case 2:

                    // Create a new invoice

                    System.out.print("Ange den totala summan för den nya fakturan: ");

                    double totalInvoice = scanner.nextDouble();

                    double vat = totalInvoice * 0.25; // 25% VAT

                    double netInvoice = totalInvoice - vat;



                    accountBalance += netInvoice; // Update account balance



                    System.out.printf("Bruttosumma: %.2f%n", totalInvoice);

                    System.out.printf("Moms (25%%): %.2f%n", vat);

                    System.out.printf("Nettosumma: %.2f%n", netInvoice);

                    System.out.printf("Uppdaterat kontosaldo: %.2f%n", accountBalance);

                    break;



                case 3:

                    // Pay one or more invoices

                    System.out.print("Ange antal fakturor som ska betalas: ");

                    int numInvoices = scanner.nextInt();

                    double[] invoiceAmounts = new double[numInvoices];

                    double totalInvoiceCost = 0;



                    for (int i = 0; i < numInvoices; i++) {

                        System.out.print("Ange summan för faktura " + (i + 1) + ": ");

                        invoiceAmounts[i] = scanner.nextDouble();

                        double netInvoiceAmount = invoiceAmounts[i] / 1.25; // Remove VAT

                        totalInvoiceCost += netInvoiceAmount;

                    }



                    accountBalance -= totalInvoiceCost; // Update account balance



                    System.out.printf("Totalkostnad för fakturor (exkl. moms): %.2f%n", totalInvoiceCost);

                    System.out.printf("Kontosaldo efter att fakturorna betalats: %.2f%n", accountBalance);

                    break;



                case 4:

                    // Exit the program

                    System.out.println("Programmet avslutas. Tack för att du använde systemet!");

                    exit = true;

                    break;



                default:

                    System.out.println("Ogiltigt val, försök igen.");

                    break;

            }

        }



        scanner.close();

    }

}

