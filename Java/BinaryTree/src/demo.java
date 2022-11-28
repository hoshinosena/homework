public class demo {
    private static void test(BTreeClass<Character> test) {
        System.out.println(test.toString());
        System.out.println(test.size());
        System.out.println(test.height());
        System.out.println(test.contains('a'));
        System.out.println(test.contains('C'));
        //System.out.println(test.search('C'));
        test.preOrder();
        System.out.println();
        test.inOrder();
        System.out.println();
        test.postOrder();
        System.out.println();
        test.leverOrder();
        System.out.println();
    }
    public static void main(String[] args) {
        BTreeClass<Character> test = new BTreeClass<>();
        //test.CreateBTree("A");
        //test.CreateBTree("A(B,C)");
        //test.CreateBTree("A(B(D,E),C(F,G))");
        test.CreateBTree("A(B(D,F(E)),C(G(H),I))");
        //test.CreateBTree("A(,B(,C(,D)))");
        //test.CreateBTree("A(B(C(D(E))))");
        //test.CreateBTree("A(,C(D(,E)))");
        test(test);
        test.CreateBTree("A(B(D(H(P,Q),I(R,S)),E(J(T,U),K(V,W))),C(F(L(X,Y),M(Z,0)),G(N(1,2),O(3,4))))");
        test(test);
        test.CreateBTree("A","A");
        //test.CreateBTree("BCA","BAC");
        test.CreateBTree("DEFBHGICA","DBEFAHGCI");
        System.out.println(test.toString());
        test.CreateBTree("P Q H R S I D T U J V W K E B X Y L Z 0 M F 1 2 N 3 4 O G C A ","P H Q D R I S B T J U E V K W A X L Y F Z M 0 C 1 N 2 G 3 O 4 ");
        System.out.println(test.toString());

        test.CreateBTree("A(B(D(F(,I),G),E(,H(J))),C)");
        test(test);
        test.CreateBTree("I F G D J H E B C A ", "F I D G B E J H A C ");
        test(test);
    }
}
