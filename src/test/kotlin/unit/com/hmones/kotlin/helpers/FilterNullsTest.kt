package unit.com.hmones.kotlin.helpers

import com.hmones.kotlin.helpers.filterIfAllNulls
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class FilterNullsTest {
    @Test
    fun `it can filter nulls from a data class`() {
        val dataClassWithNulls = DataClassWithNulls(null, null, null)
        val filteredDataClass = dataClassWithNulls.filterIfAllNulls()
        assertThat(filteredDataClass).isNull()
    }

    @Test
    fun `it can return the object if not all members are null`() {
        val dataClassWithNulls = DataClassWithNulls("a", null, null)
        val filteredDataClass = dataClassWithNulls.filterIfAllNulls()
        assertThat(filteredDataClass).isEqualTo(dataClassWithNulls)
    }
}

data class DataClassWithNulls(val a: String?, val b: String?, val c: String?)
