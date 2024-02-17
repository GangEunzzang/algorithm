#include <cstdio>
int tc, hak, cnt;
double res, tmp;
char sbj[103], sco[3];
int main() {
    for (scanf("%d", &tc); tc--;) {
        scanf("%s %d %s", sbj, &hak, sco);
        if (sco[0] == 'A') tmp = 4; if (sco[0] == 'C') tmp = 2; 
        if (sco[0] == 'B') tmp = 3; if (sco[0] == 'D') tmp = 1;
        if (sco[1] == '+') tmp += 0.3; if (sco[1] == '-') tmp -= 0.3;
        cnt += hak; res += tmp * hak; tmp = sco[1] = 0;
    }
    printf("%.2lf", res / cnt + 0.0001);
    return 0;
}