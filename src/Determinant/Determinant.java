package Determinant;

public class Determinant {
    private int n;
    public double data[][];

    /**
     *
     * @param size 行列式大小
     */
    public Determinant(int size){
        n=size;
        data=new double[n][n];
    }

    /**
     *
     * @param size 行列式大小
     * @param list 行列式数据
     */
    public Determinant(int size,double...list){

        n=size;
        data=new double[n][n];
        int c=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                data[i][j]=list[c];
                c++;
            }
        }
    }

    /**
     * 递归法计算行列式
     * @return 行列式的值
     */
    public double val(){
        if(n<=2){
            if(n==2){
                return data[0][0]*data[1][1]-data[0][1]*data[1][0];
            }
            if(n==1){
                return data[0][0];
            }
        }
        double re=0;
        for(int i = 0; i<n; i++){
            var t=new Determinant(n-1);
            for(int r=0, rx=0;r<n;r++){
                if(r!=i) {
                    for(int f=1;f<n;f++){
                        t.data[rx][f-1]=data[r][f];
                    }
                    rx++;
                }
            }
            re+=t.val()*data[i][0]*(i%2==0?1:-1);
        }
        return re;
    }

    /**
     * 行列式转置
     */
    public void transpose(){
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                double x= data[i][j];
                data[i][j]=data[j][i];
                data[j][i]=x;
            }
        }
    }


}
