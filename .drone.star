def main(ctx):
  return {
    "kind": "pipeline",
    "name": "build",
    "steps": [
      {
        "name": "build",
        "image": "gradle:6.0.1-jdk8",
        "commands": [
          "gradle build",
          "gradle shadowJar"
        ]
      }
    ]
  }
