./gradlew \
    clean \
    uninstallAll \
    lintRelease \
    unitTest \
    androidTest \
    assembleRelease \
    zipProguardRelease \
    -PbuildNumber=$1

open app/build/reports/lint-results-release.html
open app/build/reports/androidTests/connected/index.html
open app/build/reports/tests/testDebugUnitTest/index.html
