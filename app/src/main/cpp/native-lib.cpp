#include <jni.h>
#include <string>

using namespace std;

extern "C" JNIEXPORT jdouble JNICALL
Java_uz_orifjon_calculatornative_MainActivity_plus(
        JNIEnv *env,
        jobject /* this */,double a,double b) {
        double result = a;
        result += b;
    return (jdouble) result;
}

extern "C" JNIEXPORT jdouble JNICALL
Java_uz_orifjon_calculatornative_MainActivity_minus(
        JNIEnv *env,
        jobject /* this */,double a,double b) {
        double result = a;
        result -= b;
    return (jdouble) result;
}

extern "C" JNIEXPORT jdouble JNICALL
Java_uz_orifjon_calculatornative_MainActivity_multiply(
        JNIEnv *env,
        jobject /* this */,double a,double b) {
        double result = a;
        result *= b;
    return (jdouble) result;
}

extern "C" JNIEXPORT jdouble JNICALL
Java_uz_orifjon_calculatornative_MainActivity_divide(
        JNIEnv *env,
        jobject /* this */,double a,double b) {
        double result = a;
        result /= b;
    return (jdouble) result;
}


