package hdh;

import java.util.*;

public class FIFO19 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int soKhung = 4, soTrang = 6, n = 10;
        int a[] = new int[n];
        int d[] = new int[1005];
        System.out.print("Input: ");
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        Queue<Integer> qu = new LinkedList<>();
        int loiTrang = 0, cnt = 0;
        for (int i = 0; i < n; i++) {
            boolean check = false;
            if (!qu.contains(a[i])) {
                if (qu.size() == soKhung) {
                    check = true;
                    loiTrang++;
                    int x = qu.poll();
                    for (int j = 1; j <= soKhung; j++) {
                        if (d[j] == x) {
                            d[j] = a[i];
                            break;
                        }
                    }
                } else {
                    cnt++;
                    d[cnt] = a[i];
                }
                qu.add(a[i]);
            }
            System.out.print("Them trang: " + a[i] + " ");
            System.out.print("Hang doi: ");
            for (int j = 1; j <= soKhung; j++) {
                if (d[j] != 0) {
                    System.out.print(d[j] + " ");
                }
            }
            if (check) {
                System.out.print("F");
            }
            System.out.println("");
        }
        System.out.println("So lan loi trang: " + loiTrang);
    }
}
