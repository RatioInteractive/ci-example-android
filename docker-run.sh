docker run \
   -it --rm \
   -v "$PWD":/workspace \
   randr0id/android-docker \
   sh -c "cd /workspace && $@"
