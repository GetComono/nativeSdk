ADD THE AAR AS A DEPENDENCY

To use the Android library's code in your app module, proceed as follows:

Navigate to: File > Project Structure > Dependencies.

In the Declared Dependencies tab, click  and select Jar Dependency in the dropdown.

In the Add Jar/Aar Dependency dialog, first enter the path to the .aar or .jar file, then select the configuration to which the dependency applies. If the library should be available to all configurations, select the "implementation" configuration.

Check your app’s build.gradle file to confirm a declaration similar to the following (depending on the build configuration you’ve selected):

implementation files('your_file_path/comodo_library.aar')

Alternatively, if you’re running Gradle builds outside of Android Studio, it’s possible to import a dependency by adding a path to the dependency in your app’s build.gradle file. For example:

dependencies {
    implementation fileTree(dir: "libs", include: ["*.jar", "*.aar"])
    ...
}

HOW TO PASS VALUES

Go to VerificationRequest.kt under io.comono.comodo_library.data.remote.dto and enter your custom strings in the quotes below to pass your parameters to the SDK for validation and handling. Also, don't for get to import the page or fragment passing the values so the strings' actual values can be processes and not the strings themselves. Use the first three entries below as an example.

@Serializable
data class CreateNewRequest(
    val workitemId: String? = "$workitemId",
    val customerName: String? = "$customerName",
    val customerEmail: String? = "customerEmail",
    val branchCode: String? = "",
    val segmentId: String? = "",
    val address: String? = "",
    val landmark: String? = "",
    val state: String? = "",
    val lga: String? = "",
    val createdBy: String? = "",
    val customerImage: String? = "",
    val Latitude: String? = "",
    val Longitude: String? = ""
)

DEVELOPMENT CONSIDERATIONS FOR LIBRARY MODULES

As you integrate the library modules and dependent apps, be aware of the following behaviors and limitations.

Once you have added references to the library module to your Android app module, you can set their relative priority. At build time, the library modules are merged with the app one at a time, starting from the lowest priority to the highest.

1. Resource merge conflicts

The build tools merge resources from a library module with those of a dependent app module. If a given resource ID is defined in both modules, the resource from the app is used.

If conflicts occur between multiple AAR libraries, then the resource from the library listed first in the dependencies list (toward the top of the dependencies block) is used.

To avoid resource conflicts for common resource IDs, consider using a prefix or other consistent naming scheme that is unique to the module (or is unique across all project modules).

2. In multi-module builds, JAR dependencies are treated as transitive dependencies

When you add a JAR dependency to a library project that outputs an AAR, the JAR is processed by the library module and packaged with its AAR.

However, if your project includes a library module that is consumed by an app module, the app module treats the library's local JAR dependency as a transitive dependency. In this case, the local JAR is processed by the app module that consumes it, and not by the library module. This is to speed up incremental builds that are caused by changes to a library's code.

Any Java resource conflicts caused by local JAR dependencies must be resolved in the app module that consumes the library.

3. A library module can depend on an external JAR library.

4. The app module's minSdkVersion must be equal to or greater than the version defined by the library

A library is compiled as part of the dependent app module, so the APIs used in the library module must be compatible with the platform version that the app module supports.

5. Each library has its own R class, named according to the library's package name. The R class generated from main module and the library module is created in all the packages that are needed including the main module's package and the libraries' packages.

However, if your library module is a part of a multi-module build that compiles into an APK and does not generate an AAR, you should run code shrinking on only the app module that consumes the library. To learn more about ProGuard rules and their usage, read Shrink, obfuscate, and optimize your app.

6. Testing a library module is the same as testing an app

The main difference is that the library and its dependencies are automatically included as dependencies of the test APK. This means that the test APK includes not only its own code, but also the library's AAR and all its dependencies. Because there is no separate "app under test," the androidTest task installs (and uninstalls) only the test APK.

When merging multiple manifest files, Gradle follows the default priority order and merges the library's manifest into the test APK's main manifest.