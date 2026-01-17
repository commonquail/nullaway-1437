package example;
import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;
import java.util.function.Function;
@NullMarked
class Scratch {
  void g1(
      Function<@Nullable Object, String> f1,
      Function<@NonNull Object, String> f2,
      Function<Object, String> f3) {
    // true negative
    f1.apply(null);
    // Maven: false negative
    // Gradle, JSpecifyMode=true: true positive
    // Gradle, JSpecifyMode=false: false negative
    f2.apply(null);
    f3.apply(null);
  }
}
