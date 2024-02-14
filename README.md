### Guía de Instalación y Configuración de Commitizen

Esta es una breve guía sobre cómo instalar y configurar Commitizen en tu sistema.

## Instalación de Commitizen

Commitizen es una herramienta para estandarizar los mensajes de confirmación. Sigue estos pasos para instalarlo:

1. Abre tu terminal (Git Bash, Command Prompt, Terminal, etc.).

2. Ejecuta el siguiente comando para instalar Commitizen globalmente en tu sistema:

    ```bash
    npm install -g commitizen
    ```

## Configuración de Commitizen en Español

Para configurar Commitizen para que utilice el idioma español cuando ejecutes `git cz`, sigue estos pasos:

1. Asegúrate de tener instalado el adaptador convencional en español. Puedes instalarlo ejecutando el siguiente comando:

    ```bash
    npm install -g cz-conventional-changelog-es
    ```

2. Luego, crea un archivo llamado `.czrc` en el directorio raíz de tu proyecto o en tu directorio de usuario.

3. Dentro de `.czrc`, agrega la siguiente línea para especificar el adaptador convencional en español:

    ```json
    {
      "path": "cz-conventional-changelog-es"
    }
    ```

   Esto le dice a Commitizen que utilice el adaptador convencional de Commitizen en español para generar mensajes de confirmación.

Con estos pasos, deberías tener Commitizen instalado y configurado correctamente en tu sistema para utilizarlo en español cuando ejecutes `git cz`.
## Agregar la ruta de instalación de npm a la variable de entorno PATH

Es posible que necesites agregar la ruta de instalación de npm a la variable de entorno PATH para que Git Bash pueda encontrar los comandos instalados globalmente. Sigue estos pasos:

1. Encuentra la ruta de instalación de npm. Por lo general, está dentro del directorio de instalación de Node.js. Por ejemplo, `C:\Program Files\nodejs\node_modules\npm`.

2. Abre la configuración de variables de entorno en tu sistema:
    - Haz clic derecho en "Este equipo" o "Mi PC" y selecciona "Propiedades".
    - Haz clic en "Configuración avanzada del sistema".
    - Haz clic en el botón "Variables de entorno".

3. En la sección "Variables del sistema" (o "Variables de usuario"), encuentra la variable de entorno llamada "Path" o "PATH" y selecciónala.

4. Haz clic en el botón "Editar" para modificar la variable de entorno PATH.

5. Haz clic en "Nuevo" y pega la ruta de instalación de npm que encontraste anteriormente. Por ejemplo, `C:\Program Files\nodejs\node_modules\npm`.

6. Guarda los cambios y cierra todas las ventanas.

7. Reinicia Git Bash para que los cambios surtan efecto.

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
