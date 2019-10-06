<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

    <xsl:output omit-xml-declaration="yes"/>

    <xsl:template match="/">
        <html>
            <body>
                <table border="1">
                    <thead>
                        <tr>
                            <th>Title</th>
                            <th>Author</th>
                            <th>Cost</th>
                        </tr>
                    </thead>
                    <xsl:for-each select="BookCatalogue/Book">
                        <tr>
                            <xsl:call-template name="PrintBook"/>
                        </tr>
                    </xsl:for-each>
                </table>
            </body>
        </html>
    </xsl:template>

    <xsl:template name="PrintBook">
        <td>
            <xsl:value-of select="Title"/>
        </td>
        <td>
            <xsl:value-of select="Author"/>
        </td>
        <td>
            <xsl:value-of select="Cost"/>
        </td>
    </xsl:template>

</xsl:stylesheet>