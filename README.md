# generic-web-view-app
Application android en Kotelin, elle permet a partir d'un site web de creer une application mobile.

## Pour modifier l'url à afficher : 
1. Appuie long sur l'icon de l'empreinte en haut.
2. Saisir le lien vers un site web.
3. submit.


## Pour créer une application costume : 
0. cloner ce repo Github : https://github.com/anesboz/generic-web-view-app 
1. **TRES IMPORTANT** : il faut changer le `applicationId` dans `build.gradle`
2. dans `src/main/res/values/strings.xml` modifier :
```
<resources>
    <string name="app_name">WebViewApp</string>
    <string name="my_url">https://www.google.fr/</string>
</resources>
```
3. Créer une icon app > clickDroit > New > Image Assets  
   (Il faut garder le nom ic_launcher ou bien le changer dans `src/main/AndroidManifest.xml`)
4. Build > Build APK (application in `app\build\outputs\apk\debug`)
