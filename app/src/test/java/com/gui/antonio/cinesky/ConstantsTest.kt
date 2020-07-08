package com.gui.antonio.cinesky

import com.gui.antonio.cinesky.utils.Constants
import org.junit.Test
import org.junit.Assert.*

class ConstantsTest {

    @Test
    fun verifyKeyBundleMovies(){
        assertEquals(Constants.KEY_TITLE_MOVIE, "TITLE_MOVIE")
    }
}