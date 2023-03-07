public class Bola {
    double diameter,jrjr;
    Bola(){
        diameter = 0;
        jrjr = 0;
    }

    Bola(double Diameter){
        diameter = Diameter;
        jrjr = diameter/2;
    }

    double luasPermukaan(){
        return jrjr*jrjr*(3.14)*4;
    }

    double volume(){
        return (4*Math.pow(jrjr,3)*(3.14))/3;
    }

    void tampil(){
        System.out.println("Diameter = "+diameter);
        System.out.println("Jari - Jari = "+jrjr);
        System.out.println("Luas Permukaan = "+luasPermukaan());
        System.out.println("Volume = "+volume());
    }
}
