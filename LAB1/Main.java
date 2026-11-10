class CDiem {
    protected float x, y;

    public CDiem(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public float khoangCach(CDiem other) {
        return (float) Math.sqrt(Math.pow(this.x - other.x, 2) + Math.pow(this.y - other.y, 2));
    }
}

// Lớp cơ sở
class CHinhVe {
    public float dienTich() { return 0.0f; }
    public float chuVi() { return 0.0f; }
    public void ve() { System.out.println("Vẽ hình vẽ"); }
}

// Lớp CTamGiac
class CTamGiac extends CHinhVe {
    protected CDiem p1, p2, p3;

    public CTamGiac(CDiem p1, CDiem p2, CDiem p3) {
        this.p1 = p1; this.p2 = p2; this.p3 = p3;
    }

    @Override
    public float chuVi() {
        float a = p1.khoangCach(p2);
        float b = p2.khoangCach(p3);
        float c = p3.khoangCach(p1);
        return a + b + c;
    }

    @Override
    public float dienTich() {
        float a = p1.khoangCach(p2);
        float b = p2.khoangCach(p3);
        float c = p3.khoangCach(p1);
        float p = chuVi() / 2; // Nửa chu vi
        return (float) Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }

    @Override
    public void ve() {
        System.out.println("=== HÌNH TAM GIÁC ===");
        System.out.println("Cong thuc Chu vi: P = a + b + c");
        System.out.println("=> Ket qua Chu vi: " + chuVi());
        System.out.println("Cong thuc Dien tich (Heron): S = sqrt(p*(p-a)*(p-b)*(p-c))");
        System.out.println("=> Ket qua Dien tich: " + dienTich());
    }
}

// Lớp CEllipse
class CEllipse extends CHinhVe {
    protected CDiem cDiemTam;
    protected float floatA, floatB;

    public CEllipse(CDiem cDiemTam, float floatA, float floatB) {
        this.cDiemTam = cDiemTam;
        this.floatA = floatA;
        this.floatB = floatB;
    }

    @Override
    public float chuVi() {
        // Công thức xấp xỉ chu vi ellipse
        return (float) (2 * Math.PI * Math.sqrt((floatA * floatA + floatB * floatB) / 2));
    }

    @Override
    public float dienTich() {
        return (float) (Math.PI * floatA * floatB);
    }

    @Override
    public void ve() {
        System.out.println("=== HÌNH ELLIPSE ===");
        System.out.println("Cong thuc Chu vi (xap xi): P = 2 * PI * sqrt((a^2 + b^2) / 2)");
        System.out.println("=> Ket qua Chu vi: " + chuVi());
        System.out.println("Cong thuc Dien tich: S = PI * a * b");
        System.out.println("=> Ket qua Dien tich: " + dienTich());
    }
}

public class Main {
    public static void main(String[] args) {
        CTamGiac tg = new CTamGiac(new CDiem(0, 0), new CDiem(3, 0), new CDiem(0, 4));
        
        CEllipse el = new CEllipse(new CDiem(0, 0), 5, 3);

        // Xuất kết quả
        tg.ve();
        System.out.println(); 
        el.ve();
    }
}