#include <jni.h>
#include <string>
using namespace std;
extern "C"
JNIEXPORT
jstring
JNICALL
Java_aes_gorio_com_myapplication_MainActivity_stringFromJNI(
        JNIEnv *env,
        jobject /* this */) {
    std::string hello = "Hello from C++";
    return env->NewStringUTF(hello.c_str());
}
extern "C"
JNIEXPORT jint JNICALL
Java_aes_gorio_com_myapplication_MainActivity_addTwoNum(JNIEnv *env, jobject instance, jint a,
                                                        jint b) {

    // TODO
    return a+b;
}extern "C"
JNIEXPORT jstring JNICALL
Java_aes_gorio_com_myapplication_JniTest_helloworld(JNIEnv *env, jclass type) {

    // TODO
    string hello = "hello world";
    return env->NewStringUTF(hello.c_str());
}