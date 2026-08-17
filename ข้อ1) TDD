/**
 * ตรวจว่าชื่อผู้ใช้ผ่านกฎหรือไม่
 * @param name ชื่อผู้ใช้
 * @return true ถ้าผ่าน R2–R5, false ถ้าความยาว/ตัวแรก/ตัวอักษร/ช่องว่างไม่ผ่าน
 * @throws IllegalArgumentException เมื่อ name เป็น null
 */
boolean isValidUsername(String name) { ... }

// test (ตัวอย่างชุดที่ครอบ)
check("valid", isValidUsername("Ace_01") == true)
check("ขึ้นต้นด้วยตัวเลข", isValidUsername("1abc") == false)
check("มีช่องว่าง", isValidUsername("A ce") == false)
check("มีอักขระแปลก", isValidUsername("Ace!") == false)
check("len 2", isValidUsername("Ab") == false)     // ขอบ-1
check("len 3", isValidUsername("Abc") == true)     // ขอบล่าง
check("len 12", isValidUsername("Abcdefghijkl") == true)
check("len 13", isValidUsername("Abcdefghijklm") == false)
boolean threw=false
try { isValidUsername(null) } catch (IllegalArgumentException e) { threw=true }
check("null throw", threw)

boolean isValidUsername(String name) {
    if (name == null) throw new IllegalArgumentException();
    if (name.length() < 3 || name.length() > 12) return false;
    if (มีช่องว่าง(name)) return false;
    if (!เป็นตัวอักษร(name.charAt(0))) return false;
    for (char c : name) {
        if (!(ตัวอักษรหรือเลขหรือ_(c))) return false;
    }
    return true;
}
