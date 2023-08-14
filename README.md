<h1>D287 Task 1</h1>

<h2>Notes</h2>
    I added the line numbers to each section of this README at the time that it was commited. The original
    line number reflects the line number at the time of the commit. I've added the commit sha and its commit
    message so you can look back at it. I've also looked over the project again and added update statements
    to all the line numbers that I noticed change. 

<h2>Part C:</h2>
    Associated commits: 50ac9575275ea137ad23aeb58acfe51786ee567a
<br/>
    Commit Messages: "Customize User Interface"
<br/>
<br/>
    File Name: mainscreen.html
<br/>
    Line Number: 14
<br/>
    Change: Changed the title to Glenns Computer Store.
<br/>
    Line Number: 19
<br/>
    Change: Changed main header to Glenns Computer Store.
<br/>
    Notes: Part and product names will be in the user interface once added in part E. This should fulfil part C
<br/>
<br/>
    File Name: confirmationaddpart.html
<br/>
    Line Number: 12 
<br/>
    Change: Changed to GCS Main Screen.
<br/>
    Line Number: 7
<br/>
    Change: Changed title to Add Part Confirmation.
<br/>
<br/>
    File Name: confirmationaddproduct.html 
<br/>
    Line Number: 12
<br/>
    Change: Changed to GCS Main Screen.
<br/>
    Line Number: 7
<br/>
    Change: Changed title to Add Product Confirmation.
<br/>
<br/>
    File Name: confirmationassocpart.html
<br/>
    Line Number: 12
<br/>
    Change: Changed to GCS Main Screen.
<br/>
    Line Number: 7
<br/>
    Change: Changed title to Associated part confirmation.
<br/>
<br/>
    File Name: confirmationdeletepart.html
<br/>
    Line Number: 12
<br/>
    Change: Changed to GCS Main Screen.
<br/>
    Line Number: 7
<br/>
    Change: Changed title to Delete part confirmation.
<br/>
<br/>
    File Name: confirmationdeleteproduct.html
<br/>
    Line Number: 12
<br/>
    Change: Changed to GCS Main Screen.
<br/>
    Line Number: 7
<br/>
    Change: Changed title to Delete Product Confirmation.
<br/>
<br/>
    File Name: inhousePartForm.html
<br/>
    Line Number: 30 (Update: 40)
<br/>
    Change: Changed to GCS Main Screen.
<br/>
<br/>
    File Name: negativeerror.html
<br/>
    Line Number: 9
<br/>
    Change: Changed to GCS Main Screen.
<br/>
<br/>
    File Name: OutsourcedPartForm.html
<br/>
    Line Number: 29 (Updated: 39)
<br/>
    Change: Changed to GCS Main Screen.
<br/>
<br/>
    File Name: productForm.html
<br/>
    Line Number: 74
<br/>
    Change: Changed to GCS Main Screen.
<br/>
<br/>
    File Name: saveproductscreen.html
<br/>
    Line Number: 9
<br/>
    Change: Changed to GCS Main Screen.
<br/>
<br/>

<h2>Part D:</h2>
    Associated commits: 763374b3d93f2515f227e25d4c3dc30411ecb2de
<br/>
    Commit Messages: "Creates about.html and its controller. Adds navigation to and from about.html and mainscreen.html."
<br/>
<br/>
    File Name: mainscreen.html
<br/>
    Line Number: 20
<br/>
    Change: Added an href to the about page.
<br/>
<br/>
    File Name: about.html
<br/>
    Line Number: All
<br/>
    Change: Added the html file for the about page, populated it with some information about the company and added
            a href back to the main screen. 
<br/>
<br/>
    File Name: AboutController.java
<br/>
    Line Number: All
<br/>
    Change: Added the controller for the about page which allows the reference to about.html in mainscreen.html to work.
            Simple class it just imports the controller and getmapping annotations and then returns the about.html page
            for get requests made to the /about path.
<br/>
<br/>
<h2>Part E:</h2>
    Associated commits: 68b64713d8adf86e1461b6bda1d9c34b9ceefecd
<br/>
    Commit Messages: "Creates default inventory for the store."
<br/>
<br/>
    File Name: BootStrapData.java
<br/>
    Line Number: 72-153
<br/>
    Change: Created an if block that checks if each of the three repositories are empty. If they are empty this block
            creates the default inventory by creating each product and part. Saving the products to the db. Setting
            the product set on each part which then maps to PRODUCT_PART. Then persisting each part to the DB which
            also persists the mapping to PRODUCT_PART. After that it sets the part set on each product object. 
            No persistence needs to be done after this since PRODUCT_PART relationship was already mapped and persisted 
            when the parts were saved. This should fulfil all of part E.
<br/>
<br/>
    File Name: InhousePart.java
<br/>
    Line Number: 23-34
<br/>
    Change: Created a new constructor that sets name, price and inv to the values I pass in. I noticed that the part_id
            column in the parts table was set to 0 for all in house parts. Part id's from my experience in warehouse
            environments tend to be random numerical or alphanumerical numbers. So I also made each constructor 
            automatically set the part id variable to a random number.
<br/>
<br/>
    File Name: OutsourcedPart.java
<br/>
    Line Number: 20-25
<br/>
    Change: Created a new constructor that sets name, price, inv and company to the values I pass in.
<br/>
<br/>
<h2>Part F:</h2>
    Associated commits: 85e4e8fff067355714443f29ff681e9ca190af9c
<br/>
    Commit Messages: "Adds buy button to products."
<br/>
<br/>
    File Name: mainscreen.html
<br/>
    Line Number: 87-90
<br/>
    Change: Created a buy button with a thymeleaf if statement. If the inventory is 0 for the product
            it will give an alert that the inventory is empty and the buy failed. If there is an inventory
            then an alert is shown indicating that the buy was successful. 
<br/>
<br/>
    File Name: AddProductController.java
<br/>
    Line Number: 173-185 (Update: 195-208)
<br/>
    Change: Adds getMapping for the buy button. It gets the product by the ID passed in from the .html
            and then if the inventory is 0 it just redirects back to the mainscreen without changing the
            inventory. If it's not zero it decrements the inventory by 1 and then redirects to the mainscreen.
            Between this and the changes made to the mainscreen.html file all three requirements of
            part F are fulfilled. 
<br/>
<br/>
<h2>Part G:</h2>
<br/>
    Associated commits: a64954371e0bbe2a0fd43ca934184abad737f4ad, 79e437bab2365ed28ef18aa862e2f1d705c5fd02
<br/>
    Commit Messages: "Adds and Tracks max and min inventory of parts.", "Adds extra checks for parts outside min/max range when adding parts to products."
<br/>
<br/>
    File Name: Part.java
<br/>
    Line Number: 28-30 (Update: 31, 34)
<br/>
    Change: Added a minInv and maxInv field for the minimum and maximum inventory.
<br/>
    Line Number: 126-136 (Update: 130, 140)
<br/>
    Change: Added getters and setter for the min and max fields.
<br/>
    Line Number: 60-66 (Update: 64-70)
<br/>
    Change: Added constructor that allows you to set min and max fields. No checking here but it's never
            used outside of me creating the default data base so there's no conflicts with enforcing the
            inventory stays withing the min and max value by users of the inventory system. 
<br/>
<br/>
    File Name: OutsourcedPart.java
<br/>
    Line Number: 27-34
<br/>
    Change: Added constructor that allows you to set min and max fields. Only used when setting the default
            database so people using the inventory system still won't have any way of adding parts
            with inventory below or above the maximum value. 
<br/>
<br/>
    File Name: InhousePart.java
<br/>
    Line Number: 36-44
<br/>
    Change: Added constructor that allows you to set min and max fields. Only used when setting the default
            database so people using the inventory system still won't have any way of adding parts
            with inventory below or above the maximum value.
<br/>
<br/>
    File Name: BootStrapData.java
<br/>
    Line Number: 83-103
<br/>
    Change: Added min and max inventory values to all parts in the default inventory. 
<br/>
<br/>
    File Name: InhousePartForm.html
<br/>
    Line Number: 24-28
<br/>
    Change: Added inputs to the form to allow users to set the min and max inventory values.
<br/>
<br/>
    File Name: OutsourcedPartForm.html
<br/>
    Line Number: 25-29
<br/>
    Change: Added inputs to the form to allow users to set the min and max inventory values.
<br/>
<br/>
    File Name: application.properties
<br/>
    Line Number: 6
<br/>
    Change: Changed the name of the file the DB is stored in to D287-task1-DB
<br/>
<br/>
    File Name: AddInhousePartController.java
<br/>
    Line Number: 45-47
<br/>
    Change: Added an else if block between the if error block and its else block that checks if the inventory
            is outside of the range of the min and max inventory. If it is it just redirects back to the 
            InhousepartForm.html page without saving to the database. This keeps the values they set on that
            particular class instance so they don't have to re type the name, price etc. And can just adjust
            the inventory they set. This also prevents any changes from carrying over to the data model
            of mainscreen unless the created or updated part inventory is within the min and max values. 
<br/>
<br/>
    File Name: AddOutsourcedPartController.java
<br/>
    Line Number: 46-48
<br/>
    Change: Added an else if block between the if error block and its else block that checks if the inventory
is outside of the range of the min and max inventory. If it is it just redirects back to the
OutsourcedpartForm.html page without saving to the database. This keeps the values they set on that
particular class instance so they don't have to re type the name, price etc. And can just adjust
the inventory they set. This also prevents any changes from carrying over to the data model
of mainscreen unless the created or updated part inventory is within the min and max values.
<br/>
<br/>
    File Name: AddProductController.java
<br/>
    Line Number: 72
<br/>
    Change: Created a boolean for whether any of the parts inventory, after being added to a product,
            are out of range. 
<br/>
    Line Number: 78-97
<br/>
    Change: Created a loop before the loop that sets the new part inventory and saves the part to the database.
            This loop checks if any of the parts in the product will be below their minimum inventory value
            once the new inventory for the part is set. If any of them are I set the boolean outOfRange to 
            true, set the data model-this is because at this point I just redirect back to productForm if
            outOfRange is true- and then break out of the loop. The loop to set the parts and save them only
            executes if outOfRange is false.
<br/>
    Line Number: 105-110
<br/>
    Change: If outOfRange is true redirect back to part form without making any changes. If not save the
            product and redirect to the confirmation page. 
<br/>
<br/>

<h2>Part H:</h2>
    Associated commits: 0d5f005dfa0f0977153667f948b75b98035bde56
<br/>
    Commit Messages: "Adds validation and error messages for parts out of minimum and maximum inventory."
<br/>
<br/>
    File Name: AddOutsourcedPartController.java
<br/>
    Line Number: 46-48
<br/>
    Change: Removed else if block that I implemented in part G to check if inventory was out of range. The
            Validators I added throughout part H accomplish this same goal. 
<br/>
<br/>
    File Name: AddInhousePartController.java
<br/>
    Line Number: 45-47
<br/>
    Change: Removed else if block that I implemented in part G to check if inventory was out of range. The
    Validators I added throughout part H accomplish this same goal.
<br/>
<br/>
    File Name: ValidInventoryRange.java
<br/>
    Line Number: All
<br/>
    Change: Added new validation interface ValidInventoryRange.java that validates that parts are
            within the specified min/max range when added or updated. This returns the message 
            "Inventory is out of the specified range!" if isValid returns false. This is used for both
            above maxInv and below minInv. Although I don't explicitly state low inventory for below minInv and
            high inventory for above maxInv this should fulfil part H.1 and part H.3 and I think it's a more
            efficient use of code. 
<br/>
<br/>
    File Name: InventoryValidator.java
<br/>
Line Number: All
<br/>
    Change: Created file InventoryValidator.java This is the implementation for the above validator. It checks
            if the given part is within its min/max inventory range and returns true if it is and false
            otherwise.
<br/>
<br/>
    File Name: InhousePartForm.html
<br/>
    Line Number: 31-35
<br/>
    Change: Created elements that check if any errors were found in the fields and if so prints global
            errors to the screen. I chose global errors because the local errors for inventory etc implemented
            by @Min in the Parts class were already displayed on a per line bases. The validator is then the
            only global error and so this reduces redundant error messages on screen.
<br/>
<br/>
    File Name: OutsourcedPartForm.html
<br/>
Line Number: 32-36
<br/>
    Change: Created elements that check if any errors were found in the fields and if so prints global
errors to the screen. I chose global errors because the local errors for inventory etc implemented
by @Min in the Parts class were already displayed on a per line bases. The validator is then the
only global error and so this reduces redundant error messages on screen.
<br/>
<br/>
    File Name: Part.java
<br/>
    Line Number: 4 and 23
<br/>
    Change: Imported ValidInventoryRange on line 4 and annotated the class on line 23.
<br/>
    Line Number: 30-33
<br/>
    Change: Added @Min checks to both minInv and maxInv to make sure min is never set below zero.
            And max is never set below 1. I figure it doesn't make sense to have a max inventory of no
            items.
<br/>
<br/>
    File Name: ValidEnufParts.java
<br/>
    Line Number: 20
<br/>
    Change: Updated the error message to say "One or more parts have no inventory or is at the inventory minimum!".
<br/>
<br/>
    File Name: EnufPartsValidator.java
<br/>
    Line Number: 36
<br/>
    Change: Updated the if block in the for loop to "if (p.getInv() - (product.getInv() - myProduct.getInv()) < p.getMinInv())"
            This checks if the new part inventory after being reduced by the increase in the product inventory
            is less then minInv. If it is return false. If the new product inventory is less then myProduct inventory
            this block never executes and true is returned. Since minInv can't be below zero this still maintains
            the original functionality of the EnufPartsValidator class but adds support for checking it's above
            the minInv value also. 
<br/>
<br/>


<h2>Part I:</h2>
    Associated commits: 11eec9f402476c74c962d77bb6e4b7ed3db97c97
<br/>
    Commit Messages: "Creates get and set tests for minInv and maxInv"
<br/>
<br/>
    File Name: PartTest.java
<br/>
    Line Number: 159-192
<br/>
    Change: Created get and set tests for minInv and maxInv fields. 
<br/>
<br/>
<h2>Part J:</h2>
    Associated commits: 480ec4c2061bc78a8eb96fd08d595469510d50eb
<br/>
    Commit Messages: "Deletes DeletePartValidator.java"
<br/>
<br/>
    File Name: DeletePartValidator.java
<br/>
    Line Number: All
<br/>
    Change: Deleted this file as it's not used. When you try to delete a part that's used in a product it redirects
        to a can't delete page instead of using this validator. When making new files both the "class" and
        "annotation" .java files are both in new > java class. However the implementations are chosen as
        "class" and the interfaces are chosen as "annotation". The instructions say to delete the class files
        for all unused validators. I interpreted this to mean delete the implementation files but not the 
        interface files. 