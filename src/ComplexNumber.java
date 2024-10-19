public class ComplexNumber {
    private double real;
    private double imag;
    // Конструктор с двумя параметрами
    public ComplexNumber(double real,double imag){this.real=real;this.imag=imag;}
    // Конструктор с одним параметром
    public ComplexNumber(double real){this.real=real;this.imag=0.0;}
    // Конструктор по умолчанию
    public ComplexNumber(){this.real=0.0;this.imag=0.0;}

    public double getImag() {
        return imag;
    }

    public double getReal() {
        return real;
    }

    public void setImag(double imag) {
        this.imag = imag;
    }

    public void setReal(double real) {
        this.real = real;
    }
    public ComplexNumber add(ComplexNumber other){
        return new ComplexNumber(this.real+other.real,this.imag+other.imag);
    }
    public ComplexNumber sub(ComplexNumber other){
        return new ComplexNumber(this.real-other.real,this.imag-other.real);
    }
    public ComplexNumber mul(ComplexNumber other){
        double realPart=this.real* other.real-this.imag*other.imag;
        double imagPart=this.imag*other.real+this.imag*other.imag;
        return new ComplexNumber(realPart,imagPart);
    }
    public void PrintComplexNumber(){
        if(this.imag==0)
        {
            System.out.print(this.real);
        }
        if(this.imag<0)
        {
            System.out.print(this.real+this.imag + "i");
        }
        if (this.imag>0)
        {
            System.out.print(this.real+"+"+this.imag+"i");
        }
    }
}
