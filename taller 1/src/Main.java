import ucn.ArchivoEntrada;
import ucn.Registro;
import ucn.StdIn;

import java.io.IOException;


public class Main {
    public static void main(String[] args) throws IOException {

        ArchivoEntrada arch1 = new ArchivoEntrada("Productos.txt");
        String opcion = "";
        boolean valConfirmacion = false;


        while(!arch1.isEndFile()) {

            Registro regEnt1 = arch1.getRegistro();      // MODELO APPLE
            String marcaApple = regEnt1.getString();
            String modeloApple1 = regEnt1.getString();
            int precioModeloA1 = regEnt1.getInt();
            String modeloApple2 = regEnt1.getString();
            int precioModeloA2 = regEnt1.getInt();
            String modeloApple3 = regEnt1.getString();
            int precioModeloA3 = regEnt1.getInt();

            regEnt1 = arch1.getRegistro();               // MODELO SAMSUNG
            String marcaSamsung = regEnt1.getString();
            String modeloSamgung1 = regEnt1.getString();
            int precioModeloS1 = regEnt1.getInt();
            String modeloSamgung2 = regEnt1.getString();
            int precioModeloS2 = regEnt1.getInt();
            String modeloSamgung3 = regEnt1.getString();
            int precioModeloS3 = regEnt1.getInt();

            regEnt1 = arch1.getRegistro();               // MODELO HUAWEI
            String marcaHuawei = regEnt1.getString();
            String modeloHuawei1 = regEnt1.getString();
            int precioModeloH1 = regEnt1.getInt();
            String modeloHuawei2 = regEnt1.getString();
            int precioModeloH2 = regEnt1.getInt();
            String modeloHuawei3 = regEnt1.getString();
            int precioModeloH3 = regEnt1.getInt();

            int contMayorCantProdVend = -1;
            int contCantMenorDinero = 99999999;

            int contAppleVend = 0;
            int contSamsungVend = 0;
            int contHuaweiVend = 0;

            int contAppleDineroRecau=0;
            int contSamsungDineroRecau=0;
            int contHuaweiDineroRecau=0;


            while (!opcion.equalsIgnoreCase("4")) {
                System.out.println("*** BIENVENIDO ***");
                System.out.println("");
                System.out.println("MENU:");
                System.out.println("[1] Realizar una venta\n" +
                        "[2] Ver información de productos.\n" +
                        "[3] Ver estadísticas.\n" +
                        "[4] Salir.");
                System.out.println("");

                System.out.println("Ingrese una opcion(1,2,3,4): ");
                opcion = StdIn.readString();

                String nomCliente="";
                String marcProducto= "";
                String nomModelo= "";
                switch (opcion){
                    case "1":
                        System.out.println("Ingrese su nombre: ");
                        nomCliente = StdIn.readString();

                        System.out.println("Ingrese la opcion de la marca que desea");
                        System.out.println("");
                        System.out.println("[*]"+ marcaApple+ "\n" + "[*]"+ marcaSamsung+"\n" + "[*]"+marcaHuawei);
                        marcProducto = StdIn.readString();

                        if (marcProducto.equalsIgnoreCase("APPLE")){
                            System.out.println("Ingrese la opcion del modelo que desea ");
                            System.out.println("");
                            System.out.println("[*]"+modeloApple1+" -> "+ precioModeloA1+"\n"+"[*]"+modeloApple2+" -> "+precioModeloA2+"\n" + "[*]"+modeloApple3+" -> "+precioModeloA3);
                            nomModelo = StdIn.readString();

                            if (nomModelo.equalsIgnoreCase("iPhone 11")) {
                                System.out.println("Ingrese la cantidad de "+nomModelo+" que desea comprar. MAXIMO 10");
                                int cantCelulares = StdIn.readInt();

                                contAppleVend += cantCelulares;

                                if (cantCelulares <=1 && cantCelulares >= 10){
                                    System.out.println("EXCEDE LA CANTIDAD MAXIMA PERMITIDA!");
                                    StdIn.readLine();
                                }

                                int precioFinal = cantCelulares * precioModeloA1;

                                contAppleDineroRecau += precioFinal;

                            } else if (nomModelo.equalsIgnoreCase("iPhone XR")) {
                                System.out.println("Ingrese la cantidad de "+nomModelo+" que desea comprar. MAXIMO 10");
                                int cantCelulares = StdIn.readInt();

                                contAppleVend += cantCelulares;

                                if (cantCelulares <=1 && cantCelulares >= 10){
                                    System.out.println("EXCEDE LA CANTIDAD MAXIMA PERMITIDA!");
                                    StdIn.readLine();
                                }

                                int precioFinal = cantCelulares * precioModeloA2;

                                contAppleDineroRecau += precioFinal;

                            }else if (nomModelo.equalsIgnoreCase("iPhone X")) {
                                System.out.println("Ingrese la cantidad de "+nomModelo+" que desea comprar. MAXIMO 10");
                                int cantProducto = StdIn.readInt();

                                contAppleVend += cantProducto;

                                int precioFinal = cantProducto * precioModeloA3;

                                contAppleDineroRecau += precioFinal;

                                if (cantProducto > 0 && cantProducto <= 10) {

                                    System.out.println("Confirmar  la venta de " + cantProducto + " " + nomModelo + " por: $" + precioFinal);
                                    System.out.println("");
                                    System.out.println("[*] Si \n" + "[*] No");
                                    String respConfrimarVenta = StdIn.readString();

                                    if (respConfrimarVenta.equalsIgnoreCase("si")) {
                                        System.out.println("");
                                        System.out.println("Venta realizada correctamente");
                                        System.out.println("");
                                    } else if (respConfrimarVenta.equalsIgnoreCase("no")) {
                                        System.out.println("");
                                        System.out.println("Venta cancelada");
                                        System.out.println("");
                                    } else if (!respConfrimarVenta.equalsIgnoreCase("si") || !respConfrimarVenta.equalsIgnoreCase("si")) {
                                        while (!valConfirmacion) {
                                            if (respConfrimarVenta.equalsIgnoreCase("si") || respConfrimarVenta.equalsIgnoreCase("si")) {
                                                break;
                                            } else {
                                                System.out.println("INGRESE UN DATO VALIDO!");
                                                StdIn.readLine();
                                            }
                                        }
                                    }

                                }else {
                                    System.out.println("");
                                    System.out.println("");
                                    System.out.println("EL NUMERO INGRESADO NO ES VALIDO. VOLVIENDO AL MENU PRINCIPAL...");
                                    System.out.println("");
                                    System.out.println("");
                                }
                            }
                        } else if (marcProducto.equalsIgnoreCase("SAMSUNG")) {
                            System.out.println("Ingrese la opcion del modelo que desea ");
                            System.out.println("");
                            System.out.println("[*]"+modeloSamgung1+" ---> "+ precioModeloS1+"\n"+"[*]"+modeloSamgung2+" -> "+precioModeloS2+"\n" + "[*]"+modeloSamgung3+" -> "+precioModeloS3);
                            nomModelo = StdIn.readString();

                            if (nomModelo.equalsIgnoreCase("Galaxy S21")) {
                                System.out.println("Ingrese la cantidad de "+nomModelo+" que desea comprar. MAXIMO 10");
                                int cantCelulares = StdIn.readInt();

                                contSamsungVend += cantCelulares;

                                if (cantCelulares <=1 && cantCelulares >= 10){
                                    System.out.println("EXCEDE LA CANTIDAD MAXIMA PERMITIDA!");
                                    StdIn.readLine();
                                }

                                int precioFinal = cantCelulares * precioModeloS1;

                                contSamsungDineroRecau += precioFinal;

                            } else if (nomModelo.equalsIgnoreCase("Galaxy A23")) {
                                System.out.println("Ingrese la cantidad de "+nomModelo+" que desea comprar. MAXIMO 10");
                                int cantCelulares = StdIn.readInt();

                                contSamsungVend += cantCelulares;

                                if (cantCelulares <=1 && cantCelulares >= 10){
                                    System.out.println("EXCEDE LA CANTIDAD MAXIMA PERMITIDA!");
                                    StdIn.readLine();
                                }

                                int precioFinal = cantCelulares * precioModeloS2;

                                contSamsungDineroRecau += precioFinal;

                            }else if (nomModelo.equalsIgnoreCase("Galaxy S9")) {
                                System.out.println("Ingrese la cantidad de " + nomModelo + " que desea comprar. MAXIMO 10");
                                int cantProducto = StdIn.readInt();

                                contSamsungVend += cantProducto;

                                int precioFinal = cantProducto * precioModeloS3;

                                contSamsungDineroRecau += precioFinal;

                                if (cantProducto > 0 && cantProducto <= 10) {

                                    System.out.println("Confirmar  la venta de " + cantProducto + " " + nomModelo + " por: $" + precioFinal);
                                    System.out.println("");
                                    System.out.println("[*] Si \n" + "[*] No");
                                    String respConfrimarVenta = StdIn.readString();

                                    if (respConfrimarVenta.equalsIgnoreCase("si")) {
                                        System.out.println("");
                                        System.out.println("Venta realizada correctamente");
                                        System.out.println("");
                                    } else if (respConfrimarVenta.equalsIgnoreCase("no")) {
                                        System.out.println("");
                                        System.out.println("Venta cancelada");
                                        System.out.println("");
                                    } else if (!respConfrimarVenta.equalsIgnoreCase("si") || !respConfrimarVenta.equalsIgnoreCase("si")) {
                                        while (!valConfirmacion) {
                                            if (respConfrimarVenta.equalsIgnoreCase("si") || respConfrimarVenta.equalsIgnoreCase("si")) {
                                                break;
                                            } else {
                                                System.out.println("INGRESE UN DATO VALIDO!");
                                                StdIn.readLine();
                                            }
                                        }
                                    }
                                } else {
                                    System.out.println("");
                                    System.out.println("");
                                    System.out.println("EL NUMERO INGRESADO NO ES VALIDO. VOLVIENDO AL MENU PRINCIPAL...");
                                    System.out.println("");
                                    System.out.println("");

                                }
                            }
                        }else if (marcProducto.equalsIgnoreCase("HUAWEI")) {
                            System.out.println("Ingrese la opcion del modelo que desea ");
                            System.out.println("");
                            System.out.println("[*]"+modeloHuawei1+" ---> "+ precioModeloH1+"\n"+"[*]"+modeloHuawei2+" -> "+precioModeloH2+"\n" + "[*]"+modeloHuawei3+" -> "+precioModeloH3);
                            nomModelo = StdIn.readString();

                            if (nomModelo.equalsIgnoreCase("Huawei P40")) {
                                System.out.println("Ingrese la cantidad de "+nomModelo+" que desea comprar. MAXIMO 10");
                                int cantCelulares = StdIn.readInt();

                                contHuaweiVend += cantCelulares;

                                if (cantCelulares <=1 && cantCelulares >= 10){
                                    System.out.println("EXCEDE LA CANTIDAD MAXIMA PERMITIDA!");
                                    StdIn.readLine();
                                }

                                int precioFinal = cantCelulares * precioModeloH1;

                                contHuaweiDineroRecau += precioFinal;

                            } else if (nomModelo.equalsIgnoreCase("Huawei P30")) {
                                System.out.println("Ingrese la cantidad de "+nomModelo+" que desea comprar. MAXIMO 10");
                                int cantCelulares = StdIn.readInt();

                                contHuaweiVend += cantCelulares;

                                if (cantCelulares <=1 && cantCelulares >= 10){
                                    System.out.println("EXCEDE LA CANTIDAD MAXIMA PERMITIDA!");
                                    StdIn.readLine();
                                }

                                int precioFinal = cantCelulares * precioModeloH2;
                                contHuaweiDineroRecau += precioFinal;

                            }else if (nomModelo.equalsIgnoreCase("Huawei Y9s")) {
                                System.out.println("Ingrese la cantidad de " + nomModelo + " que desea comprar. MAXIMO 10");
                                int cantProducto = StdIn.readInt();

                                contHuaweiVend += cantProducto;

                                int precioFinal = cantProducto * precioModeloH3;
                                contHuaweiDineroRecau += precioFinal;

                                if (cantProducto > 0 && cantProducto <= 10) {

                                    System.out.println("Confirmar  la venta de " + cantProducto + " " + nomModelo + " por: $" + precioFinal);
                                    System.out.println("");
                                    System.out.println("[*] Si \n" + "[*] No");
                                    String respConfrimarVenta = StdIn.readString();

                                    if (respConfrimarVenta.equalsIgnoreCase("si")) {
                                        System.out.println("");
                                        System.out.println("Venta realizada correctamente");
                                        System.out.println("");
                                    } else if (respConfrimarVenta.equalsIgnoreCase("no")) {
                                        System.out.println("");
                                        System.out.println("Venta cancelada");
                                        System.out.println("");
                                    } else if (!respConfrimarVenta.equalsIgnoreCase("si") || !respConfrimarVenta.equalsIgnoreCase("si")) {
                                        while (!valConfirmacion) {
                                            if (respConfrimarVenta.equalsIgnoreCase("si") || respConfrimarVenta.equalsIgnoreCase("si")) {
                                                break;
                                            } else {
                                                System.out.println("INGRESE UN DATO VALIDO!");
                                                StdIn.readLine();
                                            }
                                        }
                                    }
                                } else {
                                    System.out.println("");
                                    System.out.println("");
                                    System.out.println("EL NUMERO INGRESADO NO ES VALIDO. VOLVIENDO AL MENU PRINCIPAL...");
                                    System.out.println("");
                                    System.out.println("");

                                }
                            }
                        }
                        if (contMayorCantProdVend < contAppleVend){
                            contMayorCantProdVend = contAppleVend;
                        } else if (contMayorCantProdVend < contHuaweiVend) {
                            contMayorCantProdVend = contHuaweiVend;
                        } else if (contMayorCantProdVend < contSamsungVend) {
                            contMayorCantProdVend = contSamsungVend;
                        }

                        if (contCantMenorDinero > contAppleDineroRecau){
                            contCantMenorDinero = contAppleDineroRecau;
                        } else if (contCantMenorDinero > contSamsungDineroRecau) {
                            contCantMenorDinero = contSamsungDineroRecau;
                        } else if (contCantMenorDinero > contHuaweiDineroRecau) {
                            contCantMenorDinero = contHuaweiDineroRecau;
                        }

                        break;
                    case "2":
                        System.out.println("***************");
                        System.out.println("  MARCA "+marcaApple+"  \n"+"***************\n"+"\n"+
                        "Producto: "+modeloApple1+" --> Precio: $"+ precioModeloA1+"\n"
                                        +"Producto: "+modeloApple2+" --> Precio: $"+ precioModeloA2+"\n"+
                                        "Producto: "+modeloApple3+"  --> Precio: $"+precioModeloA3+"\n");
                        System.out.println("***************");
                        System.out.println("MARCA "+marcaSamsung+"\n"+"***************\n"+"\n"+
                                "Producto: "+modeloSamgung1+ " --> Precio: $"+precioModeloS1+"\n"+
                                "Producto: "+modeloSamgung2+" --> Precio: $"+precioModeloS2+"\n"+
                                "Producto: "+modeloSamgung3+"  --> Precio: $"+precioModeloS3+"\n");
                        System.out.println("***************");
                        System.out.println("MARCA "+marcaHuawei+"\n"+"***************\n"+"\n"+
                                "Producto: "+modeloHuawei1+" --> Precio: $"+ precioModeloH1+"\n"+
                                "Producto: "+modeloHuawei2+" --> Precio: $"+precioModeloH2+"\n"+
                                "Producto: "+ modeloHuawei3+" --> Precio: $"+precioModeloH3);
                        try {
                            System.in.read();
                        } catch (IOException enter) {
                            enter.printStackTrace();
                        }
                        break;
                    case "3":
                        System.out.println("La marca con mayor productos vendidos es: "+contMayorCantProdVend);
                        System.out.println("La marca con la menor cantidad de dinero recaudado: "+contCantMenorDinero);

                        break;
                    case "4":
                        break;
                    default:
                        System.out.println("EL VALOR INGRESADO NO ES VALIDO");
                }
            }
        }
    }
}