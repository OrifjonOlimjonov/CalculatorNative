#include <jni.h>
#include <string>

using namespace std;

extern "C" JNIEXPORT jdouble JNICALL
Java_uz_orifjon_calculatornative_fragments_MainFragment_plus(
        JNIEnv *env,
        jobject /* this */,double a,double b) {
        double result = a;
        result += b;
    return (jdouble) result;
}

extern "C" JNIEXPORT jdouble JNICALL
Java_uz_orifjon_calculatornative_fragments_MainFragment_minus(
        JNIEnv *env,
        jobject /* this */,double a,double b) {
        double result = a;
        result -= b;
    return (jdouble) result;
}

extern "C" JNIEXPORT jdouble JNICALL
Java_uz_orifjon_calculatornative_fragments_MainFragment_multiply(
        JNIEnv *env,
        jobject /* this */,double a,double b) {
        double result = a;
        result *= b;
    return (jdouble) result;
}

extern "C" JNIEXPORT jdouble JNICALL
Java_uz_orifjon_calculatornative_fragments_MainFragment_divide(
        JNIEnv *env,
        jobject /* this */,double a,double b) {
        double result = a;
        result /= b;
    return (jdouble) result;
}


