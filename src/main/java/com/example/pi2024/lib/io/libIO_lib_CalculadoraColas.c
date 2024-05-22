
#include <jni.h>

/*
 * Class:     libIO_lib_CalculadoraColas
 * Method:    calculasls
 * Signature: (DD)D
 */
JNIEXPORT jdouble JNICALL Java_libIO_lib_CalculadoraColas_calculasls
  (JNIEnv * env1, jobject obj1, jdouble numero1, jdouble numero2){

double λ = numero1;
double µ = numero2;
double ls = λ/(µ-λ);

return ls;

}

/*
 * Class:     libIO_lib_CalculadoraColas
 * Method:    calcularlq
 * Signature: (DD)D
 */
JNIEXPORT jdouble JNICALL Java_libIO_lib_CalculadoraColas_calcularlq
  (JNIEnv * env1, jobject obj1, jdouble numero1, jdouble numero2){

double λ = numero1;
double µ = numero2;

double lq = (λ*λ)/(µ*(µ- λ));

return lq;
}

/*
 * Class:     libIO_lib_CalculadoraColas
 * Method:    calcularws
 * Signature: (DD)D
 */
JNIEXPORT jdouble JNICALL Java_libIO_lib_CalculadoraColas_calcularws
  (JNIEnv * env1, jobject obj1, jdouble numero1, jdouble numero2){

double λ = numero1;
double µ = numero2;

double ws = 1/(µ-λ);

return ws;
}

/*
 * Class:     libIO_lib_CalculadoraColas
 * Method:    calcularwq
 * Signature: (DD)D
 */
JNIEXPORT jdouble JNICALL Java_libIO_lib_CalculadoraColas_calcularwq
  (JNIEnv * env1, jobject obj1, jdouble numero1, jdouble numero2){

double λ = numero1;
double µ = numero2;

double wq = λ/(µ*(µ- λ));

return wq;
}

/*
 * Class:     libIO_lib_CalculadoraColas
 * Method:    calcularp
 * Signature: (DD)D
 */
JNIEXPORT jdouble JNICALL Java_libIO_lib_CalculadoraColas_calcularp
  (JNIEnv * env1, jobject obj1, jdouble numero1, jdouble numero2){

double λ = numero1;
double µ = numero2;
double p = λ/µ;

return p;

}

/*
 * Class:     libIO_lib_CalculadoraColas
 * Method:    calcularp0
 * Signature: (DD)D
 */
JNIEXPORT jdouble JNICALL Java_libIO_lib_CalculadoraColas_calcularp0
  (JNIEnv * env1, jobject obj1, jdouble numero1, jdouble numero2){

double λ = numero1;
double µ = numero2;
double p0 = 1-(λ/µ);

return p0;

}

/*
 * Class:     libIO_lib_CalculadoraColas
 * Method:    calcularpn
 * Signature: (DDI)D
 */
JNIEXPORT jdouble JNICALL Java_libIO_lib_CalculadoraColas_calcularpn
  (JNIEnv * env1, jobject obj1, jdouble numero1, jdouble numero2, jint numero3){

double λ = numero1;
double µ = numero2;
int n = numero3;

double  calcular(double λ, double µ, int n){
   double resultado = (1-(λ/µ));
    for(int i = 0; i < n; i++){

        resultado *= (λ/µ);

    }
        return resultado;
  }
 return calcular(λ, µ, n);

}



