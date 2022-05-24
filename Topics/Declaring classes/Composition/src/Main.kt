class OperatingSystem(var name: String = "Operating system")

class DualBoot(var primaryOs: OperatingSystem = OperatingSystem("Windows"),
               var secondaryOs: OperatingSystem = OperatingSystem("Linux"))