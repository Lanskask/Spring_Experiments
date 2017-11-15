package hello2;

public class StrLong {
    public static void main(String[] args) {
        StrLong strLong = new StrLong();
        strLong.run();
    }

    void run() {
//        this.byteToArray();
        Long l1 = new Long(10);

        System.out.println(l1.toString());
        System.out.println(l1.toString() instanceof String);

        Long l2 = new Long(123);
        System.out.println(l2.toString());
    }

    void subClass( ) {
//        System.out.println((new Long(10)).toString());
//        System.out.println( Long.toString(new Long(10) ) == null );

        SubClass subCl1 = new SubClass();
//        System.out.println( (Object) subCl1.c != null );

        SubClass subClass = new SubClass();
        if(subCl1.equals(subClass)) {
            System.out.println("It's here");
        }
    }

    void byteToArray() {
        String example = "This is an example";
        byte[] bytes = example.getBytes();

        System.out.println("Text : " + example); System.out.println("Size: " + example.length());
        System.out.println("Text [Byte Format] : " + bytes + "; " + bytes.length);
        for(byte bt: bytes) System.out.print(bt + ", "); System.out.println("\nSize: " + bytes.length);
        System.out.println("Text [Byte Format] : " + bytes.toString());

        String s = new String(bytes);
        System.out.println("Text Decryted : " + s);
    }

    class SubClass {
        long c;

        @Override
        public boolean equals(Object o) {
            boolean result = false;
            if (this == o) result = true;
            if (o == null || getClass() != o.getClass()) result = false;

            SubClass subClass = (SubClass) o;
            if (c == subClass.c) result = true;

            return result;
        }
    }

/*    public boolean equals(Object other) {
        if (other == null || other.getClass() != this.getClass()) {
            return false;
        }
//        return ((Foo)other).data == this.data;
    }*/
}
