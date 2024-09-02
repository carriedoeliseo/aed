# Paquete de latex para AED2

Aquí se encuentran los paquetes de latex utilizados por la cátedra de
*Algoritmos y Estructuras de Datos 2* para presentar contenidos. Entre ellos se
encuentran macros para describir tads y módulos de diseño.

## Instalación

### LINUX

Para instalar los paquetes, copiar la carpeta de este directorio al home y luego ejecutar (desde el path del home)

    $ sudo texhash texmf/

### WINDOWS (MiKTeX 2.9)

- Copiar las carpetas `texmf\tex\latex\aed2-*` de este directorio al directorio `tex\latex\` de la carpeta de instalación del MiKTeX. Por ejemplo: `C:\Program Files\MikTex 2.9\tex\latex\`
- Abrir las utilidad "Settings (Admin)" que se instala con MikTex
- En la pestaña "General", pulsar "Refresh FNDB" y a continuación "Update Formats"
- SI IGUAL NO COMPILA: Chequear tener instalado el paquete "xargs" de MikTex. En la instalación default, Miktex detecta al compilar un .tex si un paquete falta y pregunta si lo queremos instalar. Si no, lo instalamos a mano desde el Package Manager de Miktex.

### MAC OS X

1. Situado en `Paquetes-Latex`, Copiar texmf a `~/Library/texmf` [1]

    $ cp -a texmf/ ~/Library/texmf/

2. Ejecutar "texhash"

    $ texhash

[1] El path es posible encontrarlo usando `kpsewhich -var-value TEXMFHOME`
Por ejemplo, al usar TexLive 2013 suele estar definido en:
`/usr/local/texlive/2013basic/texmf.cnf` , TEXMFHOME = ~/Library/texmf


## Ejemplo módulos diseño

En el directorio `texmf/tex/latex/aed2-diseno/ejemplo` se encuentra
`ejemplo_modulo.tex`. Este tex presenta un ejemplo de cómo describir un módulo
utilizando las macros de latex provistas por la cátedra.

Para describir los algoritmos en pseudocódigo se utiliza el paquete
`algorithmicx` [https://ctan.org/pkg/algorithmicx]

Para presentar código C++ se utiliza el paquete `minted`
[https://ctan.org/pkg/minted]
