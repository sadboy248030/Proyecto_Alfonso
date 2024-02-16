### Guía de Instalación y Configuración de Commitizen
Creado por: Alfonso.
Esta es una breve guia sobre cómo instalar y configurar Commitizen en tu sistema.

## Instalación de Commitizen

Commitizen es una herramienta para estandarizar los mensajes de confirmación. Sigue estos pasos para instalarlo:

1. Abre tu terminal (Git Bash, Command Prompt, Terminal, etc.).

2. Ejecuta el siguiente comando para instalar Commitizen globalmente en tu sistema:

    ```bash
    npm install -g commitizen
    ```
## Configurar el archivo .czrc

El archivo `.czrc` se utiliza para personalizar el adaptador convencional de Commitizen. Sigue estos pasos para configurarlo:

1. Crea un archivo llamado `.czrc` en el directorio raíz de tu proyecto o en tu directorio de usuario.

2. Dentro de `.czrc`, agrega la siguiente línea para configurar Commitizen para utilizar el adaptador convencional de Commitizen:

    ```json
    {
      "path": "cz-conventional-changelog"
    }
    ```

   Esto le dice a Commitizen que utilice el adaptador convencional de Commitizen para generar mensajes de confirmación.

   Si estás utilizando Node.js instalado desde el sitio web oficial o mediante el administrador de versiones Node Version Manager (NVM) en Windows, la ruta donde se guarda normalmente Node.js y npm es `C:\Program Files\nodejs\node_modules\npm`.

Con estos pasos, el archivo `.czrc` debería estar configurado correctamente en tu sistema.
## Solución de Problemas con Git CZ

Si encuentras problemas al utilizar Git CZ, como la imposibilidad de realizar commits o problemas con los permisos del archivo COMMIT_EDITMSG, aquí hay algunos pasos que puedes seguir para resolverlos:

### Verificar Permisos del Archivo COMMIT_EDITMSG

Asegúrate de tener permisos de escritura en el archivo COMMIT_EDITMSG dentro del directorio `.git`. Puedes verificar los permisos utilizando el comando `ls -l` en la terminal Git Bash:

```bash
   ls -l .git //ls -l
```
Si los permisos no están configurados correctamente, puedes cambiarlos utilizando el comando chmod. Por ejemplo, para otorgar permisos de escritura, puedes ejecutar:
```bash
  chmod +w .git/COMMIT_EDITMSG
```

Forzar la Instalación de Git CZ
Si encuentras problemas al instalar Git CZ, como errores de existencia de archivos, puedes intentar forzar la instalación utilizando el comando npm install -g git-cz --force:
```bash
  npm install -g git-cz --force
```

Verificar la Versión de Git CZ
Después de la instalación, verifica la versión de Git CZ para asegurarte de que se haya instalado correctamente:
```bash
 git cz --version
```

Actualizar desde el Repositorio Remoto
Antes de realizar un push de tus cambios, asegúrate de obtener las últimas actualizaciones desde el repositorio remoto utilizando el comando git pull:

```bash
git pull
```

Enviar tus Cambios al Repositorio Remoto
Una vez que hayas realizado tus cambios y resuelto cualquier conflicto que pueda surgir al hacer pull, puedes enviar tus cambios al repositorio remoto utilizando el comando git push:
```bash
git push
```



## Configuración de Commitizen en Español

Para configurar Commitizen para que utilice el idioma español cuando ejecutes `git cz`, sigue estos pasos:

1. Asegúrate de tener instalado el adaptador convencional en español. Puedes instalarlo ejecutando el siguiente comando:

    ```bash
   npm install -g commitizen
    ```

2. Luego, crea un archivo llamado `.czrc` en el directorio raíz de tu proyecto o en tu directorio de usuario.

3. Dentro de `.czrc`, agrega la siguiente línea para especificar el adaptador convencional en español:

    ```json
   {
   "path": "cz-conventional-changelog",
   "messages": {
   "type": "Selecciona el tipo de cambio que estás confirmando:",
   "scope": "\nIndica el alcance de este cambio (opcional):",
   "customScope": "Indica el alcance de este cambio:",
   "subject": "Escribe una descripción corta y descriptiva del cambio:\n",
   "body": "Escribe una descripción más detallada del cambio (opcional). Usa '|' para una nueva línea:\n",
   "breaking": "Lista de cambios que rompen la compatibilidad (opcional):\n",
   "footer": "Lista de issues cerradas por este cambio (opcional). E.g.: #31, #34:\n",
   "confirmCommit": "¿Confirmar el mensaje de confirmación?"
   }
   }
    ```

   Esto le dice a Commitizen que utilice el adaptador convencional de Commitizen en español para generar mensajes de confirmación.

Con estos pasos, deberías tener Commitizen instalado y configurado correctamente en tu sistema para utilizarlo en español cuando ejecutes `git cz`.
## Guía para Configurar Git Bash en IntelliJ IDEA

Esta guía te mostrará cómo configurar Git Bash en IntelliJ IDEA para que puedas ejecutar comandos de Git y npm directamente desde el entorno de desarrollo integrado (IDE).

### Paso 1: Abre la Configuración

1. Abre IntelliJ IDEA.
 
2. Haz clic en "File" en la barra de menú y selecciona "Settings" (o "Preferences" en macOS).

### Paso 2: Navega a la Configuración de Terminal

1. En la ventana de configuración, navega hasta "Tools" y luego selecciona "Terminal".

### Paso 3: Configura Git Bash como Terminal Personalizado

1. En la sección "Shell path" (Ruta del shell), asegúrate de que esté seleccionada la opción "Use custom shell" (Usar shell personalizado).

2. En el campo de texto debajo de "Shell path", ingresa la ruta de tu instalación de Git Bash. Por lo general, esta ruta es `C:\Program Files\Git\bin\bash.exe` en sistemas Windows.

### Paso 4: Agrega la Ruta de Instalación de npm a la Variable de Entorno PATH

1. Encuentra la ruta de instalación de npm. Por lo general, está dentro del directorio de instalación de Node.js. Por ejemplo, `C:\Program Files\nodejs\node_modules\npm`.

2. Abre la configuración de variables de entorno en tu sistema:
    - Haz clic derecho en "Este equipo" o "Mi PC" y selecciona "Propiedades".
    - Haz clic en "Configuración avanzada del sistema".
    - Haz clic en el botón "Variables de entorno".

3. En la sección "Variables del sistema" (o "Variables de usuario"), encuentra la variable de entorno llamada "Path" o "PATH" y selecciónala.

4. Haz clic en el botón "Editar" para modificar la variable de entorno PATH.

5. Haz clic en "Nuevo" y pega la ruta de instalación de npm que encontraste anteriormente. Te saldra name:`npm`
   value:`C:\Program Files\nodejs\node_modules\npm`.



### Paso 5: Opcionalmente, Configura Ajustes Adicionales

1. Puedes configurar otros ajustes según tus preferencias, como el directorio de trabajo inicial y las opciones de inicio.

### Paso 6: Guarda los Cambios

1. Haz clic en "Apply" y despues  "OK" para cerrar la ventana de configuración y guardar los cambios.

### Paso 7: Reinicia IntelliJ IDEA

1. Reinicia IntelliJ IDEA para que los cambios surtan efecto.

Con estos pasos, Git Bash estará configurado como el terminal en IntelliJ IDEA y podrás ejecutar comandos de Git y npm directamente desde la terminal integrada en el IDE.



## Eliminar el símbolo "$" del prompt de la terminal

Si deseas eliminar el símbolo "$" del prompt de la terminal Git Bash, puedes seguir estos pasos:

1. Abre tu terminal Git Bash.

2. Abre el archivo `.bashrc` en un editor de texto. Puedes usar el siguiente comando para abrirlo en Git Bash:

    ```bash
    nano ~/.bashrc
    ```

3. Dentro del archivo `.bashrc`, busca la línea que define el prompt. Por lo general, se verá algo como esto:

    ```bash
    PS1='\[\033]0;$TITLEPREFIX:$PWD\007\]\n\[\033[32m\]\u@\h \[\033[35m\]$MSYSTEM \[\033[33m\]\w\[\033[36m\]`__git_ps1`\[\033[0m\]\n$ '
    ```

4. Elimina el símbolo "$" al final de la línea. Por ejemplo, puedes cambiar la línea a algo así:

    ```bash
    PS1='\[\033]0;$TITLEPREFIX:$PWD\007\]\n\[\033[32m\]\u@\h \[\033[35m\]$MSYSTEM \[\033[33m\]\w\[\033[36m\]`__git_ps1`\[\033[0m\]\n '
    ```

5. Guarda los cambios y cierra el editor. En Nano, puedes hacerlo presionando `Ctrl + O` para guardar y `Ctrl + X` para salir.

6. Reinicia Git Bash o ejecuta el siguiente comando para aplicar los cambios:

    ```bash
    source ~/.bashrc
    ```

Con estos pasos, el símbolo "$" debería eliminarse del prompt de tu terminal Git Bash..

Con estos pasos, deberías tener Commitizen instalado, la ruta de instalación de npm agregada a la variable de entorno PATH y el archivo .czrc configurado correctamente en tu sistema.
