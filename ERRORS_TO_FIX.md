
# Milan Android App — Known Build Errors

## 1. MilanEditProfileScreen.kt

- File: `app/src/main/java/com/example/matrimonal/ui/screens/MilanEditProfileScreen.kt`
- Location: Line 23, Column 35
- Compiler error: `Unresolved reference 'ExposedDropdownMenu'`
- Build task: `:app:compileDebugKotlin`
- Status: Needs investigation and fixing

### Build result
Command: `.\gradlew.bat assembleDebug`

Result: `BUILD FAILED`

### Note
The current code is being uploaded for teammate review.
Please investigate the compiler error before merging or modifying this screen.
