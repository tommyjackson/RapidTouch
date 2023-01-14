package com.tjackapps.rapidtouch.preferences.androidimpl

import android.content.Context
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test
import java.io.File

@OptIn(ExperimentalCoroutinesApi::class)
class PreferencesAndroidImplTest {

    private val context: Context = mockk()
    private val classUnderTest: PreferencesAndroidImpl = PreferencesAndroidImpl(context)

    @Before
    fun before() {
        every { context.applicationContext } returns context
        every { context.filesDir } returns File("")
    }

    @Test
    fun `getString returns default when preference does not exist`() = runTest {
        val expected = ""
        val actual = classUnderTest.getString("")
        assert(expected == actual)
    }

    @Test
    fun `getBoolean returns default when preference does not exist`() = runTest {
        val expected = false
        val actual = classUnderTest.getBoolean("")
        assert(expected == actual)
    }

    @Test
    fun `getInt returns default when preference does not exist`() = runTest {
        val expected = 0
        val actual = classUnderTest.getInt("")
        assert(expected == actual)
    }

    @Test
    fun `getDouble returns default when preference does not exist`() = runTest {
        val expected = 0.0
        val actual = classUnderTest.getDouble("")
        assert(expected == actual)
    }
}
