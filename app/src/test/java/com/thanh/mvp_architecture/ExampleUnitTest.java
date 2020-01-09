package com.thanh.mvp_architecture;

import com.thanh.mvp_architecture.presenter.LoginPresenter;
import com.thanh.mvp_architecture.ui.LoginActivity;
import com.thanh.mvp_architecture.ui.MainActivity;

import org.junit.Before;
import org.junit.Test;
import org.junit.internal.builders.JUnit3Builder;
import org.junit.runners.JUnit4;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    private LoginActivity activity;
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

}