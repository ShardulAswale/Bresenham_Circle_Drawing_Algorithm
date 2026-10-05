# Circle and Ellipse Rasterisation

Java OpenGL graphics exercise drawing a face from circles, an ellipse and a half ellipse.

## How it works

Decision variables select successive raster points, and symmetric points complete each shape. The scene combines these routines into an outline face. `src/shape/line.java` provides a separate radial circle example.

## Usage

Requires a Java Development Kit, a desktop display and a legacy JOGL installation compatible with the `javax.media.opengl` API. Configure the JOGL JARs and native libraries in the Java classpath, then compile `src/Bresenham/circle.java` and run `bresenham.circle`.

## Notes

The main class declares lowercase package `bresenham`, while its source directory is `Bresenham`; preserve the declared package when compiling. The local `GL2.java` stub is not a JOGL dependency replacement.
