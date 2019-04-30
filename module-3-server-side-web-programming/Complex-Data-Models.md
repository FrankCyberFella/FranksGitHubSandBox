# Complex Data Modeling

## Problem Statement

Let's hypothetically go over the design of a simple to do list data model.

- A recipe has a name, a prep time, and a category
- The recipe also has many ingredients
- Each ingredient has an ingredient name, a quantity, and a measurement type associated with it

No application that we have used required us to fill out a form to create a recipe, then complete subsequent forms for each ingredient (imagine how that user experience would be).

The designers determined that this is a poor user experience and had to come up with a way to make it easy for the user to create a recipe and add or update ingredients all from the same screen.

## Lesson Objectives

- Modeling complex objects
- Creating view models & views
- Persisting objects with a parent/child relationship

## Notes & Examples

### **1. Database Design (DTOs)**

**Recipe Table**

| Column | Type |
|--------|------|
| Id (PK) | integer |
| Name | varchar |
| DurationInMinutes | integer |
| Category | varchar |

**Ingredient Table**

| Column | Type |
|--------|------|
| Id (PK) | integer |
| RecipeID (FK) | integer |
| Type | varchar |
| Quantity | decimal |
| MeasurementType | varchar |


### **2. DTOs & View Models**

- Create DTOs for the two objects (Recipe and Ingredient).
- Create a RecipeViewModel

### **3. Inserting Parent/Child Records**

When building out the Add Recipe flow, create the Add Recipe form.
- The Add Recipe form needs to bind to a RecipeViewModel
- Add Recipe Controller Logic needs to ensure that an all or nothing operation takes place. The entire recipe is added to the database first, and then each subsequent ingredient is added within the same transaction.
- User is then taken to a View Recipe page.

### **4. Updating Parent/Child Records**

The Update / Delete page is a bit more complex. We need to recognize the following possible scenarios:
- The recipe may or may not be modified. 
- Ingredients may be added.
- Ingredients may be deleted.
- Ingredients may be modified.