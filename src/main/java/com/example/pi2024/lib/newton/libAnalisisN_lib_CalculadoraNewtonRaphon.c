
#include <jni.h>

/*
 * Class:     libAnalisisN_lib_CalculadoraNewtonRaphon
 * Method:    newton_raphson
 * Signature: (IF)F
 */
JNIEXPORT jfloat JNICALL Java_libAnalisisN_lib_CalculadoraNewtonRaphon_newton_1raphson
  (JNIEnv * env1, jobject obj1, jint opc, jfloat num){

    int eleccion = opc;
    float Xo = num;
    float x;
    float fx;
    float dfx;

        switch(eleccion){
            case 1:
                x = Xo;
                fx = x*x*x + 3*x + 1;
                dfx = 3 *( x*x) + 3;
                break;
            case 2:
                x = Xo;
                fx = x*x*x + x - 1;
                dfx = 3*x*x + 1;
                break;
            case 3:
                x = Xo;
                fx = -0.4*x*x - 2.3*x - 2.2;
                dfx = -0.8 * x - 2.3;
                break;
            case 4:
                x = Xo;
                fx = 2 * (x * x * x) - 6 * (x * x) + 3 * x + 1;
                dfx = 6 * (x * x) - 12 * x + 3;
                break;
            case 5:
                x = Xo;
                fx = -1 * (x * x ) + 2 * x + 1;
                dfx = -2 * x  + 2;
                break;
            case 6:
                x = Xo;
                fx = (x * x * x * x) - 3 * (x*x*x) + 2*x - 5;
                dfx =4 * (x * x * x ) - 9 * (x*x) + 2;
                break;
 	}
    return x - fx / dfx;

}

/*
 * Class:     libAnalisisN_lib_CalculadoraNewtonRaphon
 * Method:    error
 * Signature: (FF)F
 */
JNIEXPORT jfloat JNICALL Java_libAnalisisN_lib_CalculadoraNewtonRaphon_error
  (JNIEnv * env1, jobject obj1, jfloat numero1, jfloat numero2){

    float actual = numero1;
    float anterior = numero2;
    float error = (actual - anterior) / actual;
    float absoluto = (error >= 0) ? error : -error;

    return absoluto;
}


