class AppendArray {

  public static int [] append(int [] a, int [] b) {

    int [] c = new int [a.length + b.length];

    int cont = 0;
    for(int i = 0; i < a.length; i++) {

        c[cont] = a[i];
        cont ++;

    }
        

    for(int j = 0; j < b.length; j++) {

        c[cont] = b[j];
        cont ++;


    }
      
    return c;
  }


}