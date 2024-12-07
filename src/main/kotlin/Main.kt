package com.example

import com.microsoft.playwright.Browser
import com.microsoft.playwright.BrowserType
import com.microsoft.playwright.Playwright
import com.microsoft.playwright.options.LoadState

fun main() {
  println("Hello World!")

  Playwright.create().use { playwright ->
    playwright.firefox().launch(BrowserType.LaunchOptions().setHeadless(false))
      .use { browser ->
        val browserContext = browser.newContext(
          Browser.NewContextOptions()
        ).apply {
          setDefaultTimeout(45_000.0)
        }
        val page = browserContext.newPage()
        page.navigate("https://suiviconso.edf.fr/comprendre")
        page.waitForTimeout(120000.0)
        page.waitForLoadState(LoadState.NETWORKIDLE)
      }
  }
}
