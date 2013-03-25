
package com.silverkeytech.news_engine_tests

import org.junit.Test
import org.junit.Assert

public class RdfRssTest{
    [Test]
    public fun testCraigsList(){
        val download = downloadSingleFeed("http://bloomington.craigslist.org/apa/index.rss")
        Assert.assertTrue("Download must be true", download.isTrue())
        val feed = download.value!!
        plog("Size of download ${feed.items.size()}")
        Assert.assertTrue(feed.items.size() > 0)
    }

    [Test]
    public fun testBasicParsing(){
        val rawXml = downloadRawFeed("http://bloomington.craigslist.org/apa/index.rss")
        Assert.assertTrue("Raw xml must exists", rawXml.length() > 0)
        val res = transformXmlToRdfRss(rawXml)

        Assert.assertTrue("Transformation to RDF must be true", res.isTrue())
        val rdf = res.value!!
        Assert.assertTrue("RDF must have content", rdf.item.size() > 0)
    }
}