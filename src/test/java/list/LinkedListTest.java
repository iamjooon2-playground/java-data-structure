package list;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class LinkedListTest {

    @Test
    void simpleLinkedList() {
        SimpleList values = new SimpleLinkedList();

        values.add("first");
        values.add("second");
        assertThat(values.indexOf("second")).isEqualTo(1);
        assertThat(values.add("third")).isTrue(); // 세 번째 값을 추가한다.
        assertThat(values.contains("third")).isTrue();
        assertThat(values.indexOf("third")).isEqualTo(2);
        values.set(0, "1");
        assertThat(values.contains("1")).isTrue();
        values.set(0, "first");
        assertThat(values.size()).isEqualTo(3); // list의 크기를 구한다.
        assertThat(values.get(0)).isEqualTo("first"); // 첫 번째 값을 찾는다.
        assertThat(values.get(1)).isEqualTo("second"); // 두 번째 값을 찾는다.
        assertThat(values.get(2)).isEqualTo("third"); // 세 번째 값을 찾는다.
        assertThatThrownBy(() -> values.get(3)).isInstanceOf(RuntimeException.class);
        assertThat(values.contains("first")).isTrue(); // "first" 값이 포함되어 있는지를 확인한다.
        assertThat(values.contains("forth")).isFalse(); // "first" 값이 포함되어 있는지를 확인한다.
        assertThat(values.remove(0)).isEqualTo("first"); // 첫 번째 값을 삭제한다.
        assertThat(values.size()).isEqualTo(2); // 값이 삭제 됐는지 확인한다.
        assertThat(values.get(0)).isEqualTo("second");
        assertThat(values.get(1)).isEqualTo("third");
        assertThat(values.remove(1)).isEqualTo("third"); // 첫 번째 값을 삭제한다.
        assertThat(values.remove(0)).isEqualTo("second"); // 첫 번째 값을 삭제한다.
        assertThat(values.add("four")).isTrue();
        assertThat(values.get(0)).isEqualTo("four");
        values.add(0, "five");
        assertThat(values.get(0)).isEqualTo("five");
        assertThat(values.get(1)).isEqualTo("four");
        assertThat(values.contains("five")).isTrue();
        assertThat(values.isEmpty()).isFalse();
        assertThat(values.indexOf("five")).isEqualTo(0);
        assertThat(values.remove("five")).isTrue();
        assertThat(values.get(0)).isEqualTo("four");
        assertThat(values.set(0, "five")).isEqualTo("four");
        assertThat(values.get(0)).isEqualTo("five");
        values.clear();
        assertThat(values.size()).isEqualTo(0);
        assertThat(values.add("six")).isTrue();
        assertThat(values.add("seven")).isTrue();
        values.add(0, "eight");
    }
}
