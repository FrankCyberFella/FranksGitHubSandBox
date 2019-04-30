# MVC Views Part 3

## Problem Statement

How do we build websites that maintain consistent looks? CSS usually. This is really fragile though because it often relies on consistent HTML.

What can we do to create a consistent HTML structure that is applied across our entire site? For those familiar with old HTML, a thing called server-side includes
used to exist. We can practice something similar using our MVC applications and indicate regions of our pages that are used for layout purposes. 


## Lesson Objectives

* DRY (Don't Repeat Yourself)
* Generic Pages & Shared Layouts
* Link Generation

## Notes and Examples

### General

**Dont Repeat Yourself**
- A heavy software development principle with the focus on reducing or eliminating repition. 

**Generic Pages & Shared Layouts**
- Most web application have a common layout with a consistent experience for the user as they navigate from page to page.
- Common Layout Elements
    - Header
    - Navigation
    - Footer
    - Body or Content
    - Login / Logout Box
- *What other additional HTML structures do we often add to a page, over and over?*
    - Script Tags (Javascript)
    - Stylesheet Links
    - Meta Tags

### ASP.NET Shared Layout Pages

**Shared Layout Files**
- By convention, the default layout for an ASP.NET MVC site should be called `_Layout.cshtml`
- Shared layouts should live in the Views folder under `Views/Shared`

<div class="definition note">

A **layout page** defines the structure of the view and only defines content that applies to all views.</div>

<div class="definition note">

A **content page** makes the use of a layout page. It does not contain any `head` or `body` elements.</div>

- Layout pages are like any other HTML page, except that they contain a call to a method called `@RenderBody()`. The position indicates where the content page is included.

<div class="caution note">A layout page does not bind to a model, only a content page does.</div> 

![How Layout Pages Render](http://media-www-asp.azureedge.net/media/38709/ch03_layouts-3.jpg)

1. The browser requests a content page.
2. The content page has code that indicates which layout page to use for the page structure.
3. The layout page is pulled in and the content is inserted where `RenderBody()` is called.
4. The final output is sent back to the browser in the response.

```
@ {
    Layout = null; // indicates no layout is needed
}
```

**Layout Sections**

- Sometimes students struggle with this unless they ask questions leading to this kind of topic
    - e.g. how do I add certain CSS files or Script files from a content page

```
<div>
    @RenderSection(string name, bool required)
</div>  
```

- Implementing a section in a Content Page

```
@section SideBar {
    <p>This text goes inside the section</p>
}
```

**View Start File**

- The `_ViewStart.cshtml` file is used to automatically set the Layout property in order to eliminate setting the Layout in each Content Page.

**HTML and URL Helpers**

- Many links that we create on a dynamic website often take us from one portion of the site to another (e.g. List to Details, Department to Product, Recommended Product to Product)
- *How does it know what link to use?*

<div class="definition note">

Razor provides **HTML Helpers** is a method that returns an HTML String. It can represent any type of HTML content.</div>


```
@Html.ActionLink(string linkText, string actionName, string controllerName, object routeValues)
```

### Spring MVC Layout Templates

